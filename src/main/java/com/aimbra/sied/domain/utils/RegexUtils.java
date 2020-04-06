package com.aimbra.sied.domain.utils;

public abstract class RegexUtils {

    public static boolean isValidDomainEmail(String email, String validDomain) {
        String pattern = "";
        if (validDomain == null) {
            pattern = "^[a-z0-9.]+@catolicamacae.com?$";
        } else {
            pattern = "^[a-z0-9.]+@"+ validDomain +"?$";
        }
        return email.matches(pattern);
    }


}
