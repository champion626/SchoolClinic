package cn.myoa;

import cn.myoa.boot.config.FlywayApp;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zhangbolun on 17/10/17.
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class ApplicationRun {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRun.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(ApplicationRun.class);
        Environment env = app.run(args).getEnvironment();
        logger.info("Access URLs:\n----------------------------------------------------------\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("server.port"), InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }
}