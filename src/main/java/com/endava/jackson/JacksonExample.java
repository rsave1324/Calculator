package com.endava.jackson;

import com.endava.google.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JacksonExample {

    private static final Logger LOGGER = LogManager.getLogger(JacksonExample.class);

    public static void main(String[] args) throws JsonProcessingException {
        Payment pm = new Payment();
        pm.setAmount(100.0);
        pm.setCardNumber("1234567890");
        pm.setCurrency("EUR");
        pm.setCustomerName("Joe");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pm);
        LOGGER.info(json);

        Payment dP = objectMapper.readValue(json, Payment.class);
        LOGGER.info(dP.equals(pm));
    }
}
