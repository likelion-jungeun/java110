/* 포워드(forward)
 * => 다른 서블릿으로 작업을 위임하는 기술
 *    이전 서블릿에서 출력한 내용이 있다면 포워드 전에 버린다.
 *    그래서 작업을 위임 받은 서블릿에서 새로 출력한다.
 */
package bitcamp.java110.ex09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex09/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        // 방법1)
        // => 응답 해더에 리프래시 명령을 추가하기
        // => 다음은 응답 내용을 출력한 후, 2초 후에 http://daum.ner을 요청하라는 명령
        //res.setHeader("Refresh", "2;url=http://daum.net");
        
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        
        // 방법2)
        // => HTML의 <meta> 태그에 리프래시 명령을 설정할 수 있다. 
        // 참고로 <meta>태그는 <head> 태그 안에 기술해야한다.
        out.println("<meta http-equiv='Refresh' content='5;url=http://naver.com'>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>ex08</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>servlet01 실행</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}