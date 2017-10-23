package cn.myoa.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Created by zhangbolun on 17/10/17.
 */
@EnableScheduling
@Component
public class TimedTask {
    private static final Logger logger = LoggerFactory.getLogger(TimedTask.class);

}

