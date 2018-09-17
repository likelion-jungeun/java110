package bitcamp.java110.cms.client;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        try( 
                // 서버에 연결하기 - 서버에 연결하면 리턴할거임!
                Socket socket = new Socket("localhost",8888);

                // 서버에 데이터를 보내고 읽을 도구를 준비하기
                PrintStream out = new PrintStream(
                        new BufferedOutputStream(
                                socket.getOutputStream())); 

                

                /*InputStream in1 = socket.getInputStream();
        InputStreamReader in2=new InputStreamReader(in1);
        BufferedReader in3 = new BufferedReader(in2); 이걸 밑에처럼 줄이는거야*/

                BufferedReader in = new BufferedReader
                        (new InputStreamReader
                                (socket.getInputStream()));

          ){
            //서버에서 읽으면 다음라인으로 넘어감(즉,상대편이 읽어야 넘어감)
            //buffer가 찰때까지 출력이 안되기 때문에,flush를 사용해서 자동 출력해줘야해!!
            out.println("안녕, 나는야 정은이라눙"); out.flush();
            System.out.println(in.readLine());//상대편이 보낸거 읽고 출력
            
            while (true) {
                String requestLine = prompt();
                out.println(requestLine); out.flush();
                
                while(true) {
                    String responseLine = in.readLine();
                    System.out.println(responseLine);
                    if(responseLine.length()==0)  //빈문자열이 들어오면 
                        break;
                }
                if (requestLine.equalsIgnoreCase("EXIT")){
                        break;
                } 
            }
        }
        keyIn.close();
    }

    private static String prompt() {
        System.out.print("입력> ");
        return keyIn.nextLine();
    }
}