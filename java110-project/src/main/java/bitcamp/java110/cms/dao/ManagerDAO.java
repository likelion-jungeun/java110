package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDAO {

    int insert(Manager manager);

    List<Manager> findAll();

    // 이제 번호가 아닌, 이메일로 찾고 삭제할거임
    Manager findByEmail(String email);

    int delete(String email);
}
