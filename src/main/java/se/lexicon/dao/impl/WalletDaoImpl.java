package se.lexicon.dao.impl;

import se.lexicon.dao.WalletDao;
import se.lexicon.model.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WalletDaoImpl implements WalletDao {

    private List<Wallet> walletStorage;

    public WalletDaoImpl() {
        this.walletStorage = new ArrayList<>();
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        walletStorage.add(wallet);
        return wallet;
    }

    @Override
    public Optional<Wallet> findWallet(String id) {
      return walletStorage.stream()
                .filter( wallet -> wallet.getId().equals(id))
                .findFirst();
    }
}
