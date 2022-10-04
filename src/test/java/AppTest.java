import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AppTest {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 单元测试（不带参的get请求）
     */
    @Test
    public void testGet(){
        //请求地址
        String url = "http://localhost:8080/springtest/user/login";

        //发起请求,直接返回对象
        String str = restTemplate.getForObject(url, String.class);
        System.out.println(str);
    }
}
