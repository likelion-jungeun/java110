import java.util.Scanner;

public class App {

    // 4) 저장할 배열을 만든다
    static String[] names = new String[100];
    static String[] emails = new String[100];
    static String[] passwords = new String[100];

    static int index = 0;

    // 1) 키보드 입력을 처리할 객체 준비
    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) {

        printMembers();
        
        inputMembers();

        keyIn.close();
    }

    // 6) 메소드들을 만들고 데이터들을 옮긴다
    static void printMembers() {
        // 3) 반복문을 만든다
        while (true) {
            // 2) 사용자로부터 회원 정보 입력받기
            System.out.print("이름 : ");
            names[index] = keyIn.nextLine();// enter를 칠때까지 리턴하지 않음

            System.out.print("이메일 : ");
            emails[index] = keyIn.nextLine();

            System.out.print("암호 : ");
            passwords[index] = keyIn.nextLine();

            index++;

            System.out.print("계속 등록하시겠습니까?(Y/n)");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }

    }

    // 5) 출력을만든다
    static void inputMembers() {
        for (int i = 0; i < index; i++) {
            System.out.printf("%s, %s, %s\n", names[i], emails[i], passwords[i]);
        }
    }
}