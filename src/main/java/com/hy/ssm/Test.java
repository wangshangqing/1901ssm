package com.hy.ssm;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 * @Auther: wangsq
 * @Date: 2020/7/21 16:06
 * @Description:
 */
public class Test {
    static Logger logger=Logger.getLogger(Test.class);
    public static void main(String[] args) {



        ConsoleAppender appender=new ConsoleAppender(
                new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN),
                "System.out");
        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);
        logger.info("hello");
        logger.info("hello");
        logger.info("hello");
        logger.info("hello");
        logger.info("hello");
    }
}
