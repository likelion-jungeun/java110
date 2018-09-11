package bitcamp.java110.cms.dao;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.domain.Manager;

//@Component
public class ManagerListDAO implements ManagerDAO{

    private List<Manager> list = new ArrayList<>();

    public int insert(Manager manager) {
        for (Manager item : list) {
            if (item.getEmail().equals(manager.getEmail())) {
                return 0;
            }
        }
        list.add(manager);
        return 1;
    }

    public List<Manager> findAll() {

        return list;
    }

    // 이제 번호가 아닌, 이메일로 찾고 삭제할거임
    public Manager findByEmail(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
}
