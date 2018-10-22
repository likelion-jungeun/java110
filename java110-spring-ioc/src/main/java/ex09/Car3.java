package ex09;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Car3 {
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    private Engine engine;
    
    // ?��?���? IoC 컨테?��?��?�� 
    // ?��?��?���? ?�� 개일 ?�� ?��?��미터?�� ?��?��?��?�� ???��?�� 객체�? ?��?�� 주입?��?��.
    // => ?��?��미터?�� @Autowired�? 붙여?�� ?���?, ?��?��?��?�� ?��?��.
    public Car3(/*@Autowired*/ Engine engine) {
        System.out.println("Car(Engine) ?��출됨!");
        this.engine = engine;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }

    
    
    
    
}
