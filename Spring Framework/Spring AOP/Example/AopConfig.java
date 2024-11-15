package com.cts.SpringAopDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Configuration class for Spring AOP.
 * 
 * The @EnableAspectJAutoProxy annotation enables Aspect-Oriented Programming (AOP)
 * by allowing Spring to create proxies for beans that are advised by aspects.
 * 
 * In this case, it enables the proxy creation for EasyBank, which will be advised by
 * LoginAspect to handle cross-cutting concerns such as validation and logging.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.cts.SpringAopDemo")
public class AopConfig {
}
