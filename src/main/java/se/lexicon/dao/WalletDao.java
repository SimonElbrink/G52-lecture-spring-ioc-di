package se.lexicon.dao;

import se.lexicon.model.Wallet;

import java.util.Optional;

public interface WalletDao {

    Wallet createWallet(Wallet wallet);

    Optional<Wallet> findWallet(String id);


}
