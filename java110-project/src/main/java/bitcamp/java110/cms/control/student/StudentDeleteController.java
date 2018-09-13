package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDAO;

@Component
public class StudentDeleteController {
    StudentDAO studentDAO;

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 학생 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if (studentDAO.deleteByNo(no) > 0) {
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("해당 번호의 학생이 없습니다.");
        }
    }
}
