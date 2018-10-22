package ex02;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig() ?ò∏Ï∂úÎê®!");
    }
    
    @Bean // <== Îπ? Ïª®ÌÖå?ù¥?Ñà?óêÍ≤? ?ù¥ Î©îÏÑú?ìúÎ•? ?ò∏Ï∂úÌï¥?Ñú Î¶¨ÌÑ¥ Í∞íÏùÑ Î≥¥Í??ïò?ùº?äî Î™ÖÎ†π
    public Car getCar() {
        System.out.println("getCar() ?ò∏Ï∂úÎê®!");
        Car c = new Car();
        c.setModel("?Üå?Çò??");
        c.setCc(1998);
        c.setMaker("?òÑ???ûê?èôÏ∞?");
        return c;
    }
}
