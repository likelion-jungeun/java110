/*
 * 클라이언트로 출력하기 - Binary출력
 */
package bitcamp.java110.ex03;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
// binary - 일반 에디터로 편집 불가능(직접 편집할 수 없음)/ 예) hwp, gif, jpg, avi, exe, png, ppt, word, xls
// text - 메모장으로 편집할 수 있음/ 예) txt, html, .js, .css, gradle, xml, 
@WebServlet("/ex03/servlet04")
public class Servlet04 extends GenericServlet{

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        // 웹 애플리케이션 정보를 다루는 객체를 얻는다.
        ServletContext ctx= this.getServletContext();

        // ServletContext 객체를 통해 현재 웹 애플리케이션의 실제 경로를 알아낸다.
        String filepath = ctx.getRealPath("/WEB-INF/pic1.jpg");



        res.setContentType("image/jpeg");

        try(
                BufferedInputStream in = 
                        new BufferedInputStream(new FileInputStream(filepath));
                BufferedOutputStream out = 
                        new BufferedOutputStream(res.getOutputStream());
                ){

            int b;
            while((b= in.read())!= -1) {

                out.write(b);
            }
            out.flush();
        }
    }
}