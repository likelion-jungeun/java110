package ex02;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig() ?��출됨!");
    }
    
    @Bean // <== �? 컨테?��?��?���? ?�� 메서?���? ?��출해?�� 리턴 값을 보�??��?��?�� 명령
    public Car getCar() {
        System.out.println("getCar() ?��출됨!");
        Car c = new Car();
        c.setModel("?��?��??");
        c.setCc(1998);
        c.setMaker("?��???��?���?");
        return c;
    }
}
