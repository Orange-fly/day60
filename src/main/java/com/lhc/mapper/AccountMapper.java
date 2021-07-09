package com.lhc.mapper;

import com.lhc.pojo.Account;
import org.springframework.stereotype.Repository;

/**
 * 数据访问层接口
 */
@Repository
public interface AccountMapper {
    Account findByUsername(String username);
    Integer updateAccount(Account account);

}
