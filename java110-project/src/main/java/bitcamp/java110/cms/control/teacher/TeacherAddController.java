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
            Teacher t = new Teacher();

            System.out.print("이름 : ");
            t.setName(keyIn.nextLine());

            System.out.print("이메일 : ");
            t.setEmail(keyIn.nextLine());

            System.out.print("암호 : ");
            t.setPassword(keyIn.nextLine());

            System.out.print("전화 : ");
            t.setTel(keyIn.nextLine());

            System.out.print("급여 : ");
            t.setPay(Integer.parseInt(keyIn.nextLine()));

            System.out.print("강의과목(예: JAVA,C,C++) : ");
            t.setSubjects(keyIn.nextLine());

            teacherDAO.insert(t);

            System.out.print("계속 등록하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }

}
