package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//创建一个配置类，代替 Spring 的配置文件
@Configuration

@ComponentScan("\\")//扫描组件 \表示根目录 不能省略
@EnableAspectJAutoProxy//开启 AspectJ 的自动代理
@EnableTransactionManagement//开启注解式事务驱动
public class SpringConfig {

}
