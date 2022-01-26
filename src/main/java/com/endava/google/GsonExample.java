package com.endava.google;

import com.endava.apache.Log4jExample;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GsonExample {

    private static final Logger LOGGER = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        Payment pm = new Payment();
        pm.setAmount(100.0);
        pm.setCardNumber("1234567890");
        pm.setCurrency("EUR");
        pm.setCustomerName("Joe");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(pm);
        LOGGER.info("\n {}",json);

        Payment dp = gson.fromJson(json, Payment.class);
        LOGGER.info(pm.equals(dp));
    }
}
