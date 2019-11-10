package com.silverbars.domain;

import com.silverbars.domain.Order.Type;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderBuilder {

	// user Id value
    private long userId;
    // quantity of single order
    private BigDecimal quantity;
    // price per KG of single item
    private BigDecimal pricePerKg;
    // either BUY or SELL
    private Type type;

    // store only userid of single order
    public OrderBuilder userId(long userId) {
        this.userId = userId;
        return this;
    }
    // store only quantity of single order
    public OrderBuilder quantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }
    // store only pricePerKg of single order
    public OrderBuilder pricePerKg(BigDecimal pricePerKg) {
        this.pricePerKg = pricePerKg;
        return this;
    }
    // store only type of single order
    public OrderBuilder type(Type type) {
        this.type = type;
        return this;
    }

    // Static builder // store order until end of the program
    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    // build of order while adding new order // validation of null and scale only 2 allowed
    public Order build() {
        if (type == null || quantity == null || pricePerKg == null) {
            throw new NullPointerException();
        }
        // only 3 decimal allowed
        if (quantity.scale() > 3) {
            throw new IllegalArgumentException();
        }
        // only 2 decimal allowed
        if (pricePerKg.scale() > 2) {
            throw new IllegalArgumentException();
        }
        // order generated with only UUID - unique randam value
        return new Order(UUID.randomUUID(),
                         userId,
                         quantity.movePointRight(3).intValue(),
                         pricePerKg.movePointRight(2).intValue(),
                         type);
    }

}