package dev.syntax.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * Advice: 횡단 관심사를 구현하는 Aspect의 메서드, 이 코드에서는 log()
 * JoinPoint: 어드바이스를 적용할 메서드
 * Pointcut: 각 어드바이스에서 그 어드바이스를 적용할 메서드를 구별시켜주는 구별자
 */

@Aspect // 해당 LoggingAspect 클래스가 AOP에서 사용될 Aspect(하나의 관점)라고 명시
@Component // java 클래스이기 때문에 컴포넌트로 등록
@Slf4j // logging을 간단하게 사용할 수 있도록 제공해주는 lombok annotation
public class LoggingAspect {
    // value: 스프링 AOP가 어드바이스(log())를 적용할 메서드(대상 메서드, target method)를 식별할 때 사용하는 포인트컷 식을 지정하는 역할

    // execution: 메서드 이름 패턴 사용
    // execution( * : *, 메서드의 반환 타입은 무엇을 사용하든 관계 없음
    // dev.syntax.aop.controller 하위에 속해야함
    // 클래스 이름이 * Controller 으로 끝나야함
    // *( ) : 메서드 인수 역시 무엇이든 상관없음,
    // (..): 대상 메서드가 인수를 안받을 수도 있고, 하나 이상 임의의 개수를 받아도 상관없음
    @Before(value = "execution(* dev.syntax.aop.controller.*Controller.*(..))")
    // -> 해당 패키지 내 Controller 으로 끝나는 클래스의 모든 public 메서드에 log()를 적용하겠다는 의미
    public void log(JoinPoint joinPoint) {
        log.info("-- "
                + joinPoint.getTarget().getClass().getSimpleName() + "'s "
                + joinPoint.getSignature().getName());

        Object[] args = joinPoint.getArgs(); // getArgs(): 대상 메서드에 전달된 메서드 인수를 얻음
        for (int i = 0; i < args.length; i++) {
            log.info("args[" + i + "] -->" + args[i]);
        }
    }
}
