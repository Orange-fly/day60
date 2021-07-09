package com.lhc.service;

public interface AccountService {
    Integer transfer(Integer money, String fromAccount, String toAccount);
}
