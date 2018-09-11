package bitcamp.java110.cms.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherFileDAO implements TeacherDAO {

    private List<Teacher> list = new ArrayList<>();

    public TeacherFileDAO() {
        File dataFile = new File("data/teacher.dat");
        try (BufferedReader in = new BufferedReader(new FileReader(dataFile))) {
            while (true) {
                String line = in.readLine();
                if (line == null)
                    break;
                String[] values = line.split(",");
                Teacher t = new Teacher();
                t.setEmail(values[0]);
                t.setName(values[1]);
                t.setPassword(values[2]);
                t.setTel(values[3]);
                t.setPay(Integer.parseInt(values[4]));
                t.setSubjects(values[5]);
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        File dataFile = new File("data/teacher.dat");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(dataFile))) {
            for (Teacher t : list) {
                out.write(String.format("%s,%s,%s,%s,%d,%s\n", t.getEmail(), t.getName(), t.getPassword(), t.getTel(),
                        t.getPay(), t.getSubjects()));
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Teacher teacher) {
        for (Teacher item : list) {
            if (item.getEmail().equals(teacher.getEmail())) {
                return 0;
            }
        }
        list.add(teacher);
        save();
        return 1;
    }

    public List<Teacher> findAll() {

        return list;
    }

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
        save();
        return 0;
    }
}
