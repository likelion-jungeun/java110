package bitcamp.java110.cms.control;

import java.util.Scanner;
import bitcamp.java110.cms.dao.ManagerList;
import bitcamp.java110.cms.dao.StudentList;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;

public class ManagerController {

    public static Scanner keyIn;

    public static void serviceManagerMenu() {
        while (true) {
            System.out.println("매니저관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printManagers();
            } else if (command.equals("add")) {
                inputManagers();
            } else if (command.equals("delete")) {
                deleteManager();
            } else if (command.equals("detail")) {
                detailManager();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }

    private static void printManagers() {

        for (int i = 0; i < ManagerList.size(); i++) {
            Manager s = ManagerList.get(i);
            System.out.printf("%d: %s, %s, %s, %s \n", i, s.getName(), s.getEmail(), s.getPassword(), s.getTel(),
                    s.getPosition());
        }
    }

    private static void inputManagers() {

        while (true) {
            Manager m = new Manager();

            System.out.print("이름 : ");
            m.setName(keyIn.nextLine());

            System.out.print("이메일 : ");
            m.setEmail(keyIn.nextLine());

            System.out.print("암호 : ");
            m.setPassword(keyIn.nextLine());

            System.out.print("전화번호 : ");
            m.setTel(keyIn.nextLine());

            System.out.print("부서 : ");
            m.setPosition(keyIn.nextLine());

            ManagerList.add(m);
            System.out.print("계속 등록하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }

    }

    private static void deleteManager() {
        System.out.print("삭제할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if (no < 0 || no >= ManagerList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        ManagerList.remove(no);
        System.out.println("삭제하였습니다.");

    }

    private static void detailManager() {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());

        if (no < 0 || no >= ManagerList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Manager manager = ManagerList.get(no);
        System.out.printf("이름: %s\n", manager.getName());
        System.out.printf("이메일: %s\n", manager.getEmail());
        System.out.printf("암호: %s\n", manager.getPassword());
        System.out.printf("전화: %s\n", manager.getTel());
        System.out.printf("부서: %s\n", manager.getPassword());

    }
    static { // 클래스가 로딩될 때 자동으로 딱 한 번 실행되는 블록! Student s = new Student();
        Manager s = new Manager();
        s.setName("a");
        ManagerList.add(s);

        s = new Manager();
        s.setName("b");
        ManagerList.add(s);

        s = new Manager();
        s.setName("c");
        ManagerList.add(s);

        s = new Manager();
        s.setName("d");
        ManagerList.add(s);

        s = new Manager();
        s.setName("e");
        ManagerList.add(s);
    }

}
