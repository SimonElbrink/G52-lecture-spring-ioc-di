package se.lexicon.service.impl;

import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.exception.WalletNotFoundException;
import se.lexicon.model.CryptoCurrency;
import se.lexicon.model.Transaction;
import se.lexicon.model.Wallet;
import se.lexicon.service.TransactionManagement;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class TransactionManagementImpl implements TransactionManagement {


    private WalletDao walletDao;
    private TransactionDao transactionDao;


    //1. Check for Null
    //2. Check wallet ID exists (call Dao)
    //3. Valid amount?
    //4. Call deposit method from wallet class
    //5. Create transaction record
    //6. Save the transaction to history (dao)
    @Override
    public Transaction createDepositTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {

        if (walletId == null || cryptoCurrency == null || amount == null || description == null)
            throw new IllegalArgumentException("Transaction params were not valid");

        Optional<Wallet> optionalWallet = walletDao.findWallet(walletId);
        if (optionalWallet.isEmpty()) throw new WalletNotFoundException("Wallet not Found");

        Wallet wallet = optionalWallet.get();
        wallet.deposit(cryptoCurrency, amount);

        Transaction transaction = new Transaction("DEPOSIT", amount, walletId, cryptoCurrency.getName(), description);

        return transactionDao.createTransaction(transaction);

    }

    @Override
    public Transaction createWithdrawalTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {
        // TODO - Implement this method
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(String WalletId) {
        // TODO - Implement this method
        return List.of();
    }
}
