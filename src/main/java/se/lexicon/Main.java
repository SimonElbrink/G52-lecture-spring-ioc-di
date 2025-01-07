package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.model.CryptoCurrency;
import se.lexicon.model.Transaction;
import se.lexicon.model.Wallet;
import se.lexicon.service.TransactionManagement;
import se.lexicon.service.WalletManagement;
import se.lexicon.service.impl.TransactionManagementImpl;
import se.lexicon.service.impl.WalletManagementImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        //Setup Application
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Services
        WalletManagement walletManagement = context.getBean(WalletManagementImpl.class);
        TransactionManagement management = context.getBean(TransactionManagementImpl.class);


        Wallet simon_wallet = walletManagement.create("Simon's wallet");


        Transaction transactionBTC1Simon = management.createDepositTransaction(
                simon_wallet.getId(),
                CryptoCurrency.BTC,
                new BigDecimal(1),
                "Test"
        );

        System.out.println(transactionBTC1Simon.toString());


    }
}