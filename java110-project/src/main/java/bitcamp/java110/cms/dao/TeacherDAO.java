package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

public interface TeacherDAO {

    int insert(Teacher teacher) throws MandatoryValueDAOException, DuplicationDAOException;
    List<Teacher> findAll();
    Teacher findByEmail(String email);
    default Teacher findByNo(int no) {return null;}
    default int delete(String email){ return 0;}
    default int deleteByNo(int no){ return 0;}
}
