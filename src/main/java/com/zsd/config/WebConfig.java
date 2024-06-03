package com.zsd.config;

import com.zsd.interceptor.MyInterceptor;
import com.zsd.interceptor.MyInterceptor2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

//配置类代替 Spring MVC 的配置文件
@Configuration
//扫描组件 不能省略
@ComponentScan
//开启MVC注解驱动
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    //使用默认的servlet处理静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //配置文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSize(1024 * 1024 * 10);
        return commonsMultipartResolver;
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInterceptor myInterceptor = new MyInterceptor();
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/", "/user/login");
        MyInterceptor2 myInterceptor2 = new MyInterceptor2();
        registry.addInterceptor(myInterceptor2).addPathPatterns("/**").excludePathPatterns("/", "/user/register");
    }

    //配置视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("user");
    }

    //配置异常映射
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new
                SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.Exception", "error");
        //设置异常映射
        exceptionResolver.setExceptionMappings(prop);
        //设置共享异常信息的键
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }

    //配置生成模板解析器
//    @Bean
//    public ITemplateResolver templateResolver() {
//        WebApplicationContext webApplicationContext =
//                ContextLoader.getCurrentWebApplicationContext();
//        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过 WebApplicationContext
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(webApplicationContext.getServletContext());
//        templateResolver.setPrefix("/WEB-INF/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("UTF-8");
//        templateResolver.setTemplateMode(TemplateMode.HTML);
//        return templateResolver;
//    }
//    //生成模板引擎并为模板引擎注入模板解析器
//    @Bean
//    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        return templateEngine;
//    }
//    //生成视图解析器并未解析器注入模板引擎
//    @Bean
//    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setCharacterEncoding("UTF-8");
//        viewResolver.setTemplateEngine(templateEngine);
//        return viewResolver;
//    }
//    //添加类型转换器和格式化器
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        MyDateConverter myDateConverter = new MyDateConverter();
//        registry.addConverter(myDateConverter);
//    }
    //设置全局跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("*");
    }
}