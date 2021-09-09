package org.arkecosystem.client.api;

import cash.z.ecc.android.bip39.Mnemonics;
import cash.z.ecc.android.bip39.Mnemonics.MnemonicCode;
import com.github.rholder.retry.*;
import com.google.common.collect.Lists;
import org.arkecosystem.client.BaseClientTest;
import org.arkecosystem.crypto.encoding.Hex;
import org.arkecosystem.crypto.identities.Address;
import org.arkecosystem.crypto.identities.PublicKey;
import org.arkecosystem.crypto.networks.Devnet;
import org.arkecosystem.crypto.transactions.Serializer;
import org.arkecosystem.crypto.transactions.builder.*;
import org.arkecosystem.crypto.transactions.types.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

@SuppressWarnings("unchecked")
public class SendingTransactionsTest extends BaseClientTest {

    private static final Logger logger = LoggerFactory.getLogger(SendingTransactionsTest.class);

    private String mnemonic;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        mnemonic = System.getenv("mnemonic");
    }

    @Test
    void createTransfer() throws Exception {
        checkForTransaction(new TransferBuilder()
            .network(new Devnet().version())
            .recipient("DFGWG8exRGfCduoALKWi4LWBakqLeEpPty")
            .amount(100000L)
            .vendorField("This is a transaction from Java")
            .nonce(getNonce(passphraseToAddress(mnemonic)))
            .sign(mnemonic)
            .transaction);
    }


    @Test
    void createMupay() throws Exception {
        checkForTransaction(new MultiPaymentBuilder()
            .network(new Devnet().version())
            .addPayment("DFGWG8exRGfCduoALKWi4LWBakqLeEpPty", 100000L)
            .addPayment("DFGWG8exRGfCduoALKWi4LWBakqLeEpPty", 100000L)
            .vendorField("This is a mupay transaction from Java")
            .nonce(getNonce(passphraseToAddress(mnemonic)))
            .sign(mnemonic)
            .transaction);
    }

    @Test
    void voteAndUnvote() throws Exception {
        // Create and fund a new wallet
        String newWalletMnemonic = createMnemonicForNewWallet();
        checkForTransaction(new TransferBuilder()
            .network(new Devnet().version())
            .recipient(passphraseToAddress(newWalletMnemonic))
            .amount(300000000L)
            .vendorField("Funding wallet for voting")
            .nonce(getNonce(passphraseToAddress(mnemonic)))
            .sign(mnemonic)
            .transaction);

        // Vote
        checkForTransaction(new VoteBuilder()
            .network(new Devnet().version())
            .addVote("+038d29ec215882912ebdc5cf5189ff7c4824485573f5119aec6aa4589dd85a15dd")
            .nonce(getNonce(passphraseToAddress(newWalletMnemonic)))
            .sign(newWalletMnemonic)
            .transaction);

        // Unvote + vote
        checkForTransaction(new VoteBuilder()
            .network(new Devnet().version())
            .addVotes(Lists.newArrayList(
                "-038d29ec215882912ebdc5cf5189ff7c4824485573f5119aec6aa4589dd85a15dd",
                "+03980b0482c60610695f2edc61bcfdae0d1048fb56d0041930eddc9e5c1246a5f5"
            ))
            .nonce(getNonce(passphraseToAddress(newWalletMnemonic)))
            .sign(newWalletMnemonic)
            .transaction);

        // Unvote
        checkForTransaction(new VoteBuilder()
            .network(new Devnet().version())
            .addVote("-03980b0482c60610695f2edc61bcfdae0d1048fb56d0041930eddc9e5c1246a5f5")
            .nonce(getNonce(passphraseToAddress(newWalletMnemonic)))
            .sign(newWalletMnemonic)
            .transaction);
    }

    @Test
    void secondSignature() throws Exception {
        // Create and fund a new wallet
        String newWalletMnemonic = createMnemonicForNewWallet();
        checkForTransaction(new TransferBuilder()
            .network(new Devnet().version())
            .recipient(passphraseToAddress(newWalletMnemonic))
            .amount(500000000L)
            .vendorField("Funding wallet for registering 2nd signature")
            .nonce(getNonce(passphraseToAddress(mnemonic)))
            .sign(mnemonic)
            .transaction);

        // Register the new wallet for second signature
        checkForTransaction(new SecondSignatureRegistrationBuilder()
            .network(new Devnet().version())
            .nonce(getNonce(passphraseToAddress(newWalletMnemonic)))
            .signature("a second passphrase")
            .sign(newWalletMnemonic)
            .transaction);
    }

    @Test
    void multiSignature() throws Exception {
        // Create and fund a new wallet
        String newWalletMnemonic = createMnemonicForNewWallet();
        checkForTransaction(new TransferBuilder()
            .network(new Devnet().version())
            .recipient(passphraseToAddress(newWalletMnemonic))
            .amount(2_000_000_000L)
            .vendorField("Funding wallet for registering multi signature wallet")
            .nonce(getNonce(passphraseToAddress(mnemonic)))
            .sign(mnemonic)
            .transaction);

        // Register the new wallet for multi signature
        checkForTransaction(new MultiSignatureRegistrationBuilder()
            .network(new Devnet().version())
            .nonce(getNonce(passphraseToAddress(newWalletMnemonic)))
            .publicKeys(Lists.newArrayList(
                PublicKey.fromPassphrase(newWalletMnemonic),
                PublicKey.fromPassphrase("secret 2"),
                PublicKey.fromPassphrase("secret 3")
            ))
            .min(2)
            .multiSign(newWalletMnemonic, 0)
            .multiSign("secret 2", 1)
            .multiSign("secret 3", 2)
            .sign(newWalletMnemonic)
            .transaction);
    }

    @Test
    void delegateRegistration() throws Exception {
        // Create and fund a new wallet
        String newWalletMnemonic = createMnemonicForNewWallet();
        String address = passphraseToAddress(newWalletMnemonic);
        checkForTransaction(new TransferBuilder()
            .network(new Devnet().version())
            .recipient(address)
            .amount(5000000000L)
            .vendorField("Funding wallet for delegate registration")
            .nonce(getNonce(passphraseToAddress(mnemonic)))
            .sign(mnemonic)
            .transaction);

        // Register the new wallet as delegate
        checkForTransaction(new DelegateRegistrationBuilder()
            .network(new Devnet().version())
            .nonce(getNonce(address))
            .username("del." + address.toLowerCase().substring(0, 16))
            .sign(newWalletMnemonic)
            .transaction);

        // Resign as delegate
        checkForTransaction(new DelegateResignationBuilder()
            .network(new Devnet().version())
            .nonce(getNonce(address))
            .sign(newWalletMnemonic)
            .transaction);
    }

    private String createMnemonicForNewWallet() {
        MnemonicCode mnemonicCode = new MnemonicCode(Mnemonics.WordCount.COUNT_12, "en_US");
        StringJoiner joiner = new StringJoiner(" ");
        for (String strings : mnemonicCode) {
            joiner.add(strings);
        }
        return joiner.toString();
    }

    private String passphraseToAddress(String mnemonic) {
        return Address.fromPassphrase(mnemonic, new Devnet().version());
    }

    private int getNonce(String address) throws IOException {
        logger.info("address: {}", address);

        Map<String, Object> wallet = (Map<String, Object>) connection.api().wallets.show(address).get("data");
        return Integer.parseInt((String) wallet.get("nonce")) + 1;
    }

    private void checkForTransaction(Transaction transaction) throws IOException, ExecutionException, RetryException {
        logger.info("Transaction json {}", transaction.toJson());
        logger.info("Transaction hex {}", Hex.encode(Serializer.serialize(transaction)));

        Map<String, Object> sent = connection.api().transactions.create(Collections.singletonList(transaction.toHashMap()));
        logger.info("Response {}", sent.toString());
        assertThat(sent, hasKey("data"));
        assertThat((Map<String, ?>) sent.get("data"), hasEntry("accept", Collections.singletonList(transaction.getId())));

        getRetryer().call(() -> {
            Map<String, Object> fetched = connection.api().transactions.show(transaction.getId());

            Map<String, Object> data = (Map<String, Object>) fetched.get("data");
            if (data == null || !data.containsKey("confirmations")) {
                logger.info("Still unconfirmed");
                return false;
            }

            logger.info("Fetched transaction {}", fetched);
            return (double) data.get("confirmations") > 0.0;
        });
    }

    private Retryer<Boolean> getRetryer() {
        return RetryerBuilder.<Boolean>newBuilder()
            .retryIfExceptionOfType(Exception.class)
            .retryIfResult(aBoolean -> Objects.equals(aBoolean, false))
            .withWaitStrategy(WaitStrategies.fixedWait(2, TimeUnit.SECONDS))
            .withStopStrategy(StopStrategies.stopAfterDelay(20, TimeUnit.SECONDS))
            .build();
    }
}
