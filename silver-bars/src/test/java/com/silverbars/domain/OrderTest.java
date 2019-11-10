package com.silverbars.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.silverbars.domain.Order.Type;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    OrderBuilder orderBuilder;

    // build a new order 
    @BeforeEach
    public void setup() {

        orderBuilder = OrderBuilder.builder()
            .pricePerKg(new BigDecimal("303"))
            .quantity(new BigDecimal("10.33"))
            .type(Type.BUY)
            .userId(1111l);

    }
    
    // create acutal object order from order builder
    @Test
    public void should_transform_builder_value_into_order_value() throws Exception {

        Order order = orderBuilder.build();

        assertEquals(order.getPricePerKg(), 30300l);
        assertEquals(order.getQuantity(), 10330l);
        assertEquals(order.getType(), Type.BUY);
        assertEquals(order.getUserId(), 1111l);
    }

    // throw illegal argumnet if wrong price input
    @Test
    public void should_return_illegal_argument_when_wrong_price() throws Exception {

        orderBuilder.pricePerKg(new BigDecimal("303.011"));

        assertThrows(IllegalArgumentException.class, () -> {
            orderBuilder.build();
        });

    }
    
    // throw illegal quantity if wrong price input
    @Test
    public void should_return_illegal_argument_when_wrong_quantity() throws Exception {

        orderBuilder.quantity(new BigDecimal("30.0011"));

        assertThrows(IllegalArgumentException.class, () -> {
            orderBuilder.build();
        });
    }

    // throw null pointer exception if type is null
    @Test
    public void should_not_accept_null_type() throws Exception {

        orderBuilder.type(null);

        assertThrows(NullPointerException.class, () -> {
            orderBuilder.build();
        });
    }
}