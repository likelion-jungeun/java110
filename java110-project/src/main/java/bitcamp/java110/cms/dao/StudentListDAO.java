package bitcamp.java110.cms.dao;

import java.util.ArrayList;
import java.util.List;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.domain.Student;

//@Component
public class StudentListDAO implements StudentDAO {

    private List<Student> list = new ArrayList<>();

    public int insert(Student student) {
        for (Student item : list) {
            if (item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        return 1;
    }

    public List<Student> findAll() {

        return list;
    }

    // 이제 번호가 아닌, 이메일로 찾고 삭제할거임
    public Student findByEmail(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
}
