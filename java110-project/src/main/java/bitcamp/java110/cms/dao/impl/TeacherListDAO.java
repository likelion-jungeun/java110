package bitcamp.java110.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.domain.Teacher;


//@Component
public class TeacherListDAO {

    private List<Teacher> list = new ArrayList<>();

    public int insert(Teacher teacher) {
        for (Teacher item : list) {
            if (item.getEmail().equals(teacher.getEmail())) {
                return 0;
            }
        }
        list.add(teacher);
        return 1;
    }

    public List<Teacher> findAll() {

        return list;
    }

    // 이제 번호가 아닌, 이메일로 찾고 삭제할거임
    public Teacher findByEmail(String email) {
        for (Teacher item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for (Teacher item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
}
