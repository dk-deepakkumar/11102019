package com.silverbars.domain;

import java.util.UUID;

public final class Order {

	
    public enum Type {
        BUY, SELL;
    }

    // Unique identification
    private final UUID uuid;
    
    // userID of order
    private final long userId;
    
    // quantity of single order
    private final long quantity;
    
    // price Per KG
    private final long pricePerKg;
    
    // type of order BUY or SELL
    private final Type type;

    // Constructor
    Order(UUID uuid, long userId, long quantity, long pricePerKg, Type type) {
        this.uuid = uuid;
        this.userId = userId;
        this.quantity = quantity;
        this.pricePerKg = pricePerKg;
        this.type = type;
    }

    // getter of Uid
    public UUID getUuid() {
        return uuid;
    }
    // getter of userId
    public long getUserId() {
        return userId;
    }

    public long getQuantity() {
        return quantity;
    }
    // getter of pricePerKg
    public long getPricePerKg() {
        return pricePerKg;
    }
    // getter of type
    public Type getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Order)) return false;
        Order other = (Order) o;
        if (uuid != other.uuid) return false;
        if (userId != other.userId) return false;
        if (quantity != other.quantity) return false;
        if (pricePerKg != other.pricePerKg) return false;
        if (type != other.type) return false;

        return true;
    }
}
