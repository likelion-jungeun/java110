package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class TeacherController { //패키지클래스

    static Teacher[] teachers = new Teacher[100];
    static int teacherIndex = 0;
    public static Scanner keyIn;

    static class Teacher extends Member { //이너클래스
        protected String tel;
        protected int pay;
        protected String subjects;

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }

        public String getSubjects() {
            return subjects;
        }

        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
    }

    public static void serviceTeacherMenu() {
        while (true) {
            System.out.println("강사관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printTeachers();
            } else if (command.equals("add")) {
                inputTeachers();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }

    private static void printTeachers() {
        int count = 0;
        for (Teacher s : teachers) {

            if (count++ == teacherIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %d, [%s] \n", s.getName(), s.getEmail(), s.getPassword(), s.getTel(),
                    s.getPay(), s.getSubjects());
        }
    }

    private static void inputTeachers() {

        while (true) {
            Teacher m = new Teacher();

            System.out.print("이름 : ");
            m.setName(keyIn.nextLine());

            System.out.print("이메일 : ");
            m.setEmail(keyIn.nextLine());

            System.out.print("암호 : ");
            m.setPassword(keyIn.nextLine());

            System.out.print("전화 : ");
            m.setTel(keyIn.nextLine());

            System.out.print("급여 : ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));

            System.out.print("강의과목(예: JAVA,C,C++) : ");
            m.setSubjects(keyIn.nextLine());

            teachers[teacherIndex++] = m;

            System.out.print("계속 등록하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }

    }

}
