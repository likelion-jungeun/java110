package bitcamp.java110.cms.service;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerService {
    // 서비스 인터페이스는 업무 로직을 규칭으로 정의한다.
    // 따라서 메서드 이름은 업무에 가깝게 명명해야 한다.
    void add(Manager manager); //abstract과 protected 생략가능
    List<Manager> list();
    Manager get(int no);
    void delete(int no);
}
