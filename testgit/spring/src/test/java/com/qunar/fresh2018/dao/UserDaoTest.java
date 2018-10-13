package java.com.qunar.fresh2018.dao;


import com.qunar.fresh2018.spring.EntranceApplication;
import com.qunar.fresh2018.spring.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EntranceApplication.class)
@WebAppConfiguration public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test public void queryById() throws Exception {
        System.out.println(userDao.queryById(1));
    }

    @Test public void queryAll() throws Exception {
        System.out.println(userDao.queryAll());
    }

}