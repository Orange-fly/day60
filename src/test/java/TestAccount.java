import com.lhc.mapper.AccountMapper;
import com.lhc.pojo.Account;
import com.lhc.service.AccountService;
import com.lhc.service.impl.AccountServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lhc
 * @version V1.0
 * @date 2021/07/09
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-ms.xml")
public class TestAccount {
    @Autowired
    private AccountService accountService;
    @Test
    public void testFind01(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext-ms.xml");
        SqlSessionFactory sqlSessionFactory = ioc.getBean(SqlSessionFactory.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        Account account = accountMapper.findByUsername("Vegeta");
        System.out.println(account);
    }
    @Test
    public void testFind02(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext-ms.xml");
        AccountService accountService = ioc.getBean(AccountService.class);
        Integer transfer = accountService.transfer(100, "Goku", "Vegeta");
        System.out.println("transfer = " + transfer);
    }
}
