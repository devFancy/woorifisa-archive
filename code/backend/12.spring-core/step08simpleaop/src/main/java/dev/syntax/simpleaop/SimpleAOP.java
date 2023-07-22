package dev.syntax.simpleaop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SimpleAOP {

    public static void main(String[] args) {

        // 1. bean을 관리하고 있는 스프링 컨테이너(ApplicationContext) 생성
        // 생성자의 인수로 bean 설정 정보(.xml 파일) 전달
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // getBean()을 통해 UserController 의존성 주입
        // xml방식으로
//        UserController withoutAOP = ctx.getBean(UserController.class);
//        System.out.println(withoutAOP);

//        withoutAOP.getUsers();
//        withoutAOP.saveUser(new User(1, "Tom"));
        // -> AOP 기술을 적용하지 않았을 경우, System 출력 로직이 분리가 불가능

        // AOP 적용 후
        UserController withAOP = (UserController) ctx.getBean("proxyFactoryBean");
        withAOP.getUsers();
    }

}
