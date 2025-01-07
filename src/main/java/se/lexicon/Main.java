package se.lexicon;

import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.dao.impl.TransactionDaoImpl;
import se.lexicon.dao.impl.WalletDaoImpl;
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

        //DAO
        WalletDao walletDao = new WalletDaoImpl();
        TransactionDao transactionDao = new TransactionDaoImpl();

        //Services
        WalletManagement walletManagement = new WalletManagementImpl(walletDao);
        TransactionManagement management = new TransactionManagementImpl(walletDao, transactionDao);


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