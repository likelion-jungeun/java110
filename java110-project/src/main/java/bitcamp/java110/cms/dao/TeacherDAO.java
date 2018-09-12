package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

public interface TeacherDAO {

    int insert(Teacher teacher) throws MandatoryValueDAOException, DuplicationDAOException;

    List<Teacher> findAll();

    Teacher findByEmail(String email);

    int delete(String email);
}
