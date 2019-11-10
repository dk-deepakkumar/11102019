package com.silverbars.service;

import com.silverbars.domain.Order;
import com.silverbars.domain.Order.Type;
import com.silverbars.domain.Summary;

import java.util.List;

public interface LiveOrderBoard {

	// used to register the order
    void register(Order order);

    // used to cancel the order
    void cancel(Order order);

    // to display the summary
    List<Summary> summary(Type type);

}