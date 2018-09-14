package bitcamp.java110.cms.control.manager;

import java.io.PrintStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerListController { 

    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @RequestMapping("manager/list")
    public void list(PrintStream out) {
        List<Manager> list = managerDao.findAll();
        for (Manager m : list) {
            out.printf("%d, %s, %s, %s\n",
                    m.getNo(),
                    m.getName(), 
                    m.getEmail(), 
                    m.getPosition());
        }
    }
    
}
