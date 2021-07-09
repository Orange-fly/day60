package com.lhc.service.impl;

import com.lhc.mapper.AccountMapper;
import com.lhc.pojo.Account;
import com.lhc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("1234")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public Integer transfer(Integer money, String fromAccount, String toAccount) {
        if (money < 0){
            throw new RuntimeException("转账金额不能为负数...");
        }
        Account a = accountMapper.findByUsername(fromAccount);
        if (a == null){
            throw new RuntimeException("源账户不存在...");
        }
        Account b = accountMapper.findByUsername(toAccount);
        if (b == null){
            throw new RuntimeException("目标账户不存在...");
        }
        if (money>a.getBalance()){
            throw new RuntimeException("余额不足...");
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        a.setBalance(a.getBalance()-money);
        accountMapper.updateAccount(a);
        System.out.println(10/0);
        b.setBalance(b.getBalance()+money);
        accountMapper.updateAccount(b);
        return 1;
    }
}
