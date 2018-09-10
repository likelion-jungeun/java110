package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

@Component("hello")
public class HelloController{

  //메소드 이름이 상관없다는 것을 보여주기 위해서 원래 service 였던 것을 클래스마다 teacher, student..등으로 바꿈
    @RequestMapping
    public void hello(Scanner keyIn) {
        System.out.println("안녕하세요!!!");

    }

}
