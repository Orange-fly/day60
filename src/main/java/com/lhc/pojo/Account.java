package com.lhc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lhc
 * @version V1.0
 * @date 2021/07/09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Account {
    private Integer id;
    private String username;
    private Integer balance;
}
