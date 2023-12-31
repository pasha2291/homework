package com.solvd.service;

import com.solvd.entity.Order;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DynamicContext {
    private static Order order = null;

    public static Order getOrder() {
        initContext();
        return order;
    }

    private void initContext() {
        if(order == null) {
            order = new Order();
        }
    }
}
