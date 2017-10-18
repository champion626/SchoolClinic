package cn.myoa.boot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangbolun on 17/10/17.
 */
@Configuration
@MapperScan(basePackages = {"cn.myoa.mapper"})
public class DataBaseConfiguration {



}
