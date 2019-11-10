package com.silverbars.service.impl;

import com.silverbars.domain.Order;

public class OrderKey implements Comparable<OrderKey> {

	// Orderkey as join primary key
	
	// price per key variable
    private final long pricePerKg;
    // -1 for SELL and 1 for BUY
    private final int denominator;

   
    /**
   	 * @return the pricePerKg
   	 */
    
    public long getPricePerKg() {
        return pricePerKg;
    }

    @Override
    public int hashCode() {
        return denominator * Long.hashCode(pricePerKg);
    }
    
    // custom constructor
    public OrderKey(Order order) {
        super();
        pricePerKg = order.getPricePerKg();
        denominator = Order.Type.SELL.equals(order.getType())? -1 : 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof OrderKey)) return false;
        OrderKey other = (OrderKey) o;

        if (pricePerKg != other.pricePerKg) return false;
        if (denominator != other.denominator) return false;

        return true;
    }

    @Override
    public int compareTo(OrderKey o) {

        return (int)((o.denominator * o.pricePerKg) - (denominator * pricePerKg));
    }
}