package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDAO;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {

    StudentDAO studentDAO;

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while (true) {
            Student s = new Student();
            System.out.print("이름 : ");
            s.setName(keyIn.nextLine());

            System.out.print("이메일 : ");
            s.setEmail(keyIn.nextLine());

            System.out.print("암호 : ");
            s.setPassword(keyIn.nextLine());

            System.out.print("최종학력 : ");
            s.setSchool(keyIn.nextLine());

            System.out.print("재직여부 : (true/false) ");
            s.setWorking(Boolean.parseBoolean(keyIn.nextLine()));

            System.out.print("전화 : ");
            s.setTel(keyIn.nextLine());

            studentDAO.insert(s);

            System.out.println("계속 하시겠습니까: (Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }

}