package ex02;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig() ?ΈμΆλ¨!");
    }
    
    @Bean // <== λΉ? μ»¨ν?΄??κ²? ?΄ λ©μ?λ₯? ?ΈμΆν΄? λ¦¬ν΄ κ°μ λ³΄κ???Ό? λͺλ Ή
    public Car getCar() {
        System.out.println("getCar() ?ΈμΆλ¨!");
        Car c = new Car();
        c.setModel("????");
        c.setCc(1998);
        c.setMaker("?????μ°?");
        return c;
    }
}
