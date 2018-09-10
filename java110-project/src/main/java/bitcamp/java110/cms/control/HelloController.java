package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;

@Component("4")//이름이 value일 경우, value 생략가능.(기존에 쓴 것은 value="4"였는데 생략했음)
public class HelloController implements Controller {

    @Override
    public void service(Scanner keyIn) {
        System.out.println("안녕하세요!!!");

    }

}
