package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDAO;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {

    ManagerDAO managerDAO;

    @Autowired
    public void setManagerDAO(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @RequestMapping("manager/add")

    public void add(Scanner keyIn) {

        while (true) {
            Manager m = new Manager();

            System.out.print("이름 : ");
            m.setName(keyIn.nextLine());

            System.out.print("이메일 : ");
            m.setEmail(keyIn.nextLine());

            System.out.print("암호 : ");
            m.setPassword(keyIn.nextLine());

            System.out.print("전화번호 : ");
            m.setTel(keyIn.nextLine());

            System.out.print("부서 : ");
            m.setPosition(keyIn.nextLine());

            int rtval = 0;
            if ((rtval = managerDAO.insert(m)) > 0) {
                System.out.println("저장하였습니다.");
            } else if (rtval == -1) {
                System.out.println("필수 입력 항목이 비어있습니다.");
            } else if (rtval == -2) {
                System.out.println("같은 이메일의 매니저가 존재합니다.");
            } else {
                System.out.println("예기치 않은 오류가 발생했습니다!");
            }
            System.out.print("계속 등록하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }

    }

}
