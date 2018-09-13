package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Student;

public interface StudentDAO {

    int insert(Student student)  throws MandatoryValueDAOException, DuplicationDAOException;
    List<Student> findAll();
    Student findByEmail(String email);
    default Student findByNo(int no) {return null;}
    default int delete(String email){ return 0;}
    default int deleteByNo(int no){ return 0;}
}
