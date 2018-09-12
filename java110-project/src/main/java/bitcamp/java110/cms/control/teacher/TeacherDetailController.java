package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDAO;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {

    TeacherDAO teacherDAO;

    @Autowired
    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 번호 : ");
        String email = keyIn.nextLine();
        Teacher teacher = teacherDAO.findByEmail(email);

        if (teacher == null) {
            System.out.println("해당 이메일의 학생 정보가 없습니다.");
            return;
        }
        System.out.printf("이름: %s\n", teacher.getName());
        System.out.printf("이메일: %s\n", teacher.getEmail());
        System.out.printf("암호: %s\n", teacher.getPassword());
        System.out.printf("전화: %s\n", teacher.getTel());
        System.out.printf("급여: %d\n", teacher.getPay());
    }
}