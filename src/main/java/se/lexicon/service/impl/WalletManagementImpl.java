package se.lexicon.service.impl;

import se.lexicon.dao.WalletDao;
import se.lexicon.exception.WalletNotFoundException;
import se.lexicon.exception.WalletValidationException;
import se.lexicon.model.Wallet;
import se.lexicon.service.WalletManagement;

import java.util.Optional;

//Service
// Where business logic happens, Connect to other services, Auth, Validation ...
public class WalletManagementImpl implements WalletManagement {

    private final WalletDao walletDao;

    public WalletManagementImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    @Override
    public Wallet create(String walletName) {
        // Logics, validation, Connect to other services.
        if (walletName == null) throw new WalletValidationException("Param is not valid", "Wallet Name");
        Wallet wallet = new Wallet(walletName);

        return walletDao.createWallet(wallet);
    }

    @Override
    public Wallet getById(String id) {
        Optional<Wallet> wallet = walletDao.findWallet(id);

        if(wallet.isEmpty()) throw new WalletNotFoundException("Wallet not found.");
        return wallet.get();
    }
}
