package se.lexicon.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private String id;
    private String type; // Deposit, Withdrawal
    private BigDecimal amount;
    private String walletId;
    private String cryptoCurrencySymbol;
    private String description;
    private LocalDateTime timestamp;


    public Transaction(String type, BigDecimal amount, String walletId, String cryptoCurrencySymbol, String description) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptoCurrencySymbol = cryptoCurrencySymbol;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getCryptoCurrencySymbol() {
        return cryptoCurrencySymbol;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", walletId='" + walletId + '\'' +
                ", cryptoCurrencySymbol='" + cryptoCurrencySymbol + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
