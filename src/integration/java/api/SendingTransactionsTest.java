package api;

import com.github.rholder.retry.*;
import org.arkecosystem.crypto.encoding.Hex;
import org.arkecosystem.crypto.identities.Address;
import org.arkecosystem.crypto.networks.Devnet;
import org.arkecosystem.crypto.transactions.Serializer;
import org.arkecosystem.crypto.transactions.builder.TransferBuilder;
import org.arkecosystem.crypto.transactions.builder.VoteBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

public class SendingTransactionsTest extends BaseClientTest {

    private static final Logger logger = LoggerFactory.getLogger(SendingTransactionsTest.class);

    private String mnemonic;

    @Override
    @BeforeEach
    void setUp() {
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
            .nonce(getNonce())
            .sign(mnemonic)
            .transaction);
    }

    @Test
    void unvoteAndVote() throws Exception {
        checkForTransaction(new VoteBuilder()
            .network(new Devnet().version())
            .addVote("-038d29ec215882912ebdc5cf5189ff7c4824485573f5119aec6aa4589dd85a15dd")
            .nonce(getNonce())
            .sign(mnemonic)
            .transaction);

        checkForTransaction(new VoteBuilder()
            .network(new Devnet().version())
            .addVote("+038d29ec215882912ebdc5cf5189ff7c4824485573f5119aec6aa4589dd85a15dd")
            .nonce(getNonce())
            .sign(mnemonic)
            .transaction);
    }

    @Test
    void unvoteAndVoteCombined() throws Exception {
        checkForTransaction(new VoteBuilder()
            .network(new Devnet().version())
            .addVote("-038d29ec215882912ebdc5cf5189ff7c4824485573f5119aec6aa4589dd85a15dd")
            .addVote("+038d29ec215882912ebdc5cf5189ff7c4824485573f5119aec6aa4589dd85a15dd")
            .nonce(getNonce())
            .sign(mnemonic)
            .transaction);
    }

    private int getNonce() throws IOException {
        String address = Address.fromPassphrase(mnemonic, new Devnet().version());
        logger.info("address: {},", address);

        Map<String, Object> wallet = (Map<String, Object>) connection.api().wallets.show(address).get("data");
        return Integer.parseInt((String) wallet.get("nonce")) + 1;
    }

    private void checkForTransaction(Transaction transaction) throws IOException, ExecutionException, RetryException {
        logger.info("Transaction json {}", transaction.toJson());
        logger.info("Transaction hex {}", Hex.encode(Serializer.serialize(transaction)));

        Map<String, Object> sent = connection.api().transactions.create(Arrays.asList(transaction.toHashMap()));
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
            .withStopStrategy(StopStrategies.stopAfterDelay(10, TimeUnit.SECONDS))
            .build();
    }
}
