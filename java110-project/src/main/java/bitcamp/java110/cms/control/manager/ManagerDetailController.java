package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDAO;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerDetailController {

    ManagerDAO managerDAO;

    @Autowired
    public void setManagerDAO(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 매니저의 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        Manager m = managerDAO.findByNo(no);

        if (m == null) {
            System.out.println("해당 번호의 매니저가 없습니다.");
            return;
        }

        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("암호: %s\n", m.getPassword());
        System.out.printf("전화: %s\n", m.getTel());
        System.out.printf("부서: %s\n", m.getPosition());

    }

}
