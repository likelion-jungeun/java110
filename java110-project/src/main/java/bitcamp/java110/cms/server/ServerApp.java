package bitcamp.java110.cms.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ServerApp {

    ClassPathXmlApplicationContext iocContainer;
    RequestMappingHandlerMapping requestHandlerMap;

    public ServerApp() throws Exception {
        createIoCContainer();
        logBeansOfContainer();
        processRequestMappingAnnotation();
    }

    private void createIoCContainer() {
        iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java110/cms/conf/application-context.xml");
    }


    private void processRequestMappingAnnotation() {
        requestHandlerMap = new RequestMappingHandlerMapping();
        String[] nameList = iocContainer.getBeanDefinitionNames();
        for (String name : nameList) {
            Object obj = iocContainer.getBean(name);
            requestHandlerMap.addMapping(obj);
        }
    }


    private void logBeansOfContainer() {
        System.out.println("----------------------");
        String[] names= iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            System.out.println(name);
        }
        System.out.println("----------------------");
    }


    public void service() throws Exception {
        // 클라이언트 연결을 기다리는 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("서버 실행 중..");
        while (true) {
            Socket socket = serverSocket.accept();
            RequestWorker worker = new RequestWorker(socket);
            new Thread(worker).start();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerApp serverApp = new ServerApp();
        serverApp.service();
    }


    class RequestWorker implements Runnable{
        Socket socket;
        public RequestWorker(Socket socket) {
            this.socket=socket;
        }

        @Override
        public void run() {
            //이 메소드에 "main" 스레드에서 분리하여 독립적으로 수행할 코드를 둔다.
            try (
                    Socket socket = this.socket; //여기에 값이 있어야만이 try를 벗어날 때 close를 자동호출 함
                    //(직접호출하려면 finally에 작성해)
                    PrintWriter out = new PrintWriter
                            (new BufferedOutputStream(socket.getOutputStream()));

                    BufferedReader in = new BufferedReader
                            (new InputStreamReader(socket.getInputStream()));
                    ){
                System.out.println(in.readLine());
                out.println("Yo 써치 마이넴 온 구글");
                out.flush();

                while (true) {
                    String requestLine = in.readLine();// 클라이언트가 보낸 요청읽기
                    if (requestLine.equalsIgnoreCase("EXIT")) {
                        out.println("goodbye");
                        out.println();
                        out.flush();
                        break;
                    }

                    //요청 객체 준비
                    Request request = new Request(requestLine);

                    //응답 객체 준비
                    Response response = new Response(out);

                    RequestMappingHandler mapping = 
                            requestHandlerMap.getMapping(request.getAppPath());
                    if (mapping == null) {
                        out.println("해당 요청을 처리할 수 없습니다.");
                        out.println();
                        out.flush();
                        continue;
                    }

                    try {


                        //요청 핸들러 호출
                        mapping.getMethod().invoke(mapping.getInstance(), request, response);

                    } catch (Exception e) {
                        e.printStackTrace(); //서버콘솔창에 출력
                        out.println("요청을 처리하는 중에 오류가 발생했습니다."); //클라이언트콘솔창에출력
                    }
                    out.println();
                    out.flush();
                }//while
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }/*finally {
                try {this.socket.close();} catch(Exception e) {}
                                        이렇게 써주려면 위에 Socket socket = this.socket;을 안써줘도됨. 근데 이렇게 쓰면 길고 귀찮아서 위에 써주는거임
            }*/

        }// run()

    } // RequestWorker Class

}// ServerApp class
