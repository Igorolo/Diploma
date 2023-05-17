package com.aplication.utils;

import com.aplication.entity.Account;

public class AccountUtils {
    public static Boolean isAdmin(Account account){
        return account.getAdmin();
    }
}
