package dev.syntax.simpleaop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    /*
     * MethodBeforeAdvice
     * 대상 메서드(target method)가 실행되기 전에 처리할 내용
     *
     * AfterReturningAdvice
     * 대상 메서드의 수행이 완료된 후 호출되는 내용
     */

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        log.info("-- after / method:  {}", method);
        // before와 호출 시점만 다름
    }

    public void before(Method method, Object[] args, Object target) throws Throwable {

        log.info("-- before / method:  {}", method);

        log.info("-- before / args:  {}", args.toString());
        log.info("-- before / target:  %s", target.toString());
    }
}