package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDAO;

@Component
public class ManagerDeleteController {

    ManagerDAO managerDAO;

    @Autowired
    public void setManagerDAO(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {

        System.out.print("삭제할 매니저의 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if (managerDAO.deleteByNo(no) > 0) {
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("해당 번호의 매니저가 없습니다.");
        }
    }

}
