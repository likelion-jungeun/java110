package bitcamp.java110.cms.server;

import java.io.PrintWriter;

//클라이언트가 출력할 수 있도록 출력 스트림을 담고 있음
public class Response {
    PrintWriter out;

    public Response(PrintWriter out) {
        this.out = out;
    }

    public PrintWriter getWriter() { // 인스턴스에 저장된 printWrite객체를 리턴하는 역할
        return this.out;
    }

}
