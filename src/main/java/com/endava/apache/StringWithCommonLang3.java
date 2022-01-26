package com.endava.apache;

import org.apache.commons.lang3.StringUtils;

public class StringWithCommonLang3 {

    public static void main(String[] args) {

        boolean numeric = StringUtils.isNumeric("123");
        System.out.println(numeric);
    }
}
