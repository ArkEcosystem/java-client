package api;

import org.arkecosystem.crypto.encoding.Hex;
import org.arkecosystem.crypto.enums.Fees;
import org.arkecosystem.crypto.identities.Address;
import org.arkecosystem.crypto.networks.Devnet;
import org.arkecosystem.crypto.transactions.Serializer;
import org.arkecosystem.crypto.transactions.builder.TransferBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

public class SendingTransactionsTest extends BaseClientTest {

    private static final Logger logger = LoggerFactory.getLogger(SendingTransactionsTest.class);

    @Test
    void createTransfer() throws IOException {
        String mnemonic = System.getenv("mnemonic");
        String address = Address.fromPassphrase(mnemonic, new Devnet().version());
        logger.info("address: {},", address);

        Map<String, Object> wallet = (Map<String, Object>) connection.api().wallets.show(address).get("data");
        int nonce = Integer.parseInt((String) wallet.get("nonce")) + 1;
        Transaction transaction =
            new TransferBuilder()
                .network(new Devnet().version())
                .recipient("DFGWG8exRGfCduoALKWi4LWBakqLeEpPty")
                .amount(100000L)
                .vendorField("This is a transaction from Java")
                .version(2)
                .nonce(nonce)
                .fee(Fees.TRANSFER.getValue())
                .sign(mnemonic)
                .transaction;

        logger.info("Transaction json {}", transaction.toJson());
        logger.info("Transaction hex {}", Hex.encode(Serializer.serialize(transaction)));

        Map<String, Object> sent = connection.api().transactions.create(Arrays.asList(transaction.toHashMap()));
        logger.info("Response {}", sent.toString());
        assertThat(sent, hasKey("data"));
        assertThat((Map<String, ?>) sent.get("data"), hasEntry("accept", Collections.singletonList(transaction.getId())));
    }
}
