package dev.syntax.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "dev.syntax.aop")
@EnableAspectJAutoProxy
public class BeanConfiguration {

}
