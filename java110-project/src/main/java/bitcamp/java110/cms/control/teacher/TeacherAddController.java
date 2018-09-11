package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDAO;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {

    TeacherDAO teacherDAO;

    @Autowired
    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {

        while (true) {
            Teacher m = new Teacher();

            System.out.print("이름 : ");
            m.setName(keyIn.nextLine());

            System.out.print("이메일 : ");
            m.setEmail(keyIn.nextLine());

            System.out.print("암호 : ");
            m.setPassword(keyIn.nextLine());

            System.out.print("전화 : ");
            m.setTel(keyIn.nextLine());

            System.out.print("급여 : ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));

            System.out.print("강의과목(예: JAVA,C,C++) : ");
            m.setSubjects(keyIn.nextLine());

            if (teacherDAO.insert(m) > 0) {
                System.out.println("저장하였습니다.");
            } else {
                System.out.println("같은 이메일의 학생이 존재합니다.");
            }

            System.out.print("계속 등록하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

}
