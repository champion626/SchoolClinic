package cn.myoa.boot.config;

import cn.myoa.boot.interceptors.VerifyAuthentiyHandler;
import cn.myoa.common.utils.support.Java8TimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import javax.validation.Validator;

/**
 * Created by zhangbolun on 17/10/17.
 */
@Configuration
@ComponentScan({"cn.myoa.*",})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected VerifyAuthentiyHandler verifyAuthentiyHandler ;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/swagger/v2/api-docs", "/v2/api-docs?group=restful-api");
        registry.addRedirectViewController("/swagger/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/swagger/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/swagger/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(verifyAuthentiyHandler).addPathPatterns("/**");
    }

    @PostConstruct
    private void jacksonConfig() {
        objectMapper.registerModule(new Java8TimeModule());
    }

    @Bean(name = "validator")
    public Validator createBeanValidator() {
        return new LocalValidatorFactoryBean();
    }

}

