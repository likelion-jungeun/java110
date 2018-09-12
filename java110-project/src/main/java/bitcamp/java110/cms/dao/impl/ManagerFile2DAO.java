package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.ManagerDAO;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFile2DAO implements ManagerDAO {

    static String defaultFilename = "data/manager2.dat";
    String filename;
    private List<Manager> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public ManagerFile2DAO(String filename) {
        this.filename = filename;

        File dataFile = new File(filename);
        try (FileInputStream in0 = new FileInputStream(dataFile);
                BufferedInputStream in1 = new BufferedInputStream(in0);
                ObjectInputStream in = new ObjectInputStream(in1);) {

            list = (List<Manager>) in.readObject();
            /*
             * while (true) {
             * 
             * try { Manager m = (Manager) in.readObject(); list.add(m); } catch (Exception
             * e) { break; } }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ManagerFile2DAO() {
        this(defaultFilename);
    }

    private void save() {
        File dataFile = new File(filename);
        try ( // 이게 decorator임. 상속은 아닌데, 필요한 기능을 붙였다 뗄 수 있음.
              // 즉 OjbectOutput~에 바로 fileoutput~을 쓰고싶으면 out1대신 out0을 쓰면 됨.
                FileOutputStream out0 = new FileOutputStream(dataFile); // concrete
                BufferedOutputStream out1 = new BufferedOutputStream(out0); // decorate
                ObjectOutputStream out = new ObjectOutputStream(out1);// decorate

        ) {
            out.writeObject(list);
            /*
             * for (Manager m : list) { out.writeObject(m); }
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Manager manager) {
        // 필수 입력 항목이 비었을 경우
        if (manager.getName().length() == 0 
                || manager.getEmail().length() == 0
                || manager.getPassword().length() == 0) {
            // 예외처리 문법이 없던 시절에는, 리턴값으로 예외 상황을 호출자에게 알렸다.
            return -1;

        }
        for (Manager item : list) {
            if (item.getEmail().equals(manager.getEmail())) {

                // 이메일이 중복될 경우
                // 예외처리 문법이 없던 시절에는, 리턴값으로 예외 상황을 호출자에게 알렸다.
                return -2;
            }
        }
        list.add(manager);
        save();
        return 1;
    }

    public List<Manager> findAll() {

        return list;
    }

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
        save();
        return 0;
    }
}
