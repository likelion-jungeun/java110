package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDAO;

@Component
public class TeacherDeleteController {
    TeacherDAO teacherDAO;

    @Autowired
    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 강사 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if (teacherDAO.deleteByNo(no) > 0) {
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("해당 번호의 강사가 없습니다.");
        }

    }

}
