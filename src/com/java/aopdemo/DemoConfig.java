package com.java.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //enables spring aop use proxy for calling its target ojects
@ComponentScan("com.java.aopdemo")
public class DemoConfig {

}
