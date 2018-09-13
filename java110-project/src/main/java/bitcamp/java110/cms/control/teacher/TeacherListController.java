package bitcamp.java110.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Autowired;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDAO;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherListController {
    TeacherDAO teacherDAO;

    @Autowired
    public void setTeacherDAO(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        List<Teacher> list = teacherDAO.findAll();
        for (Teacher t : list) {
            System.out.printf("%d %s, %s, %s, %s, %d, %s \n", t.getNo(), t.getName(), t.getEmail(), t.getPassword(), t.getTel(),
                    t.getPay(), t.getSubjects());
        }
    }

}
