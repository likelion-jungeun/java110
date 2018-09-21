package bitcamp.java110.ex05;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class MyHttpServlet extends GenericServlet{


    @Override
    public void service(
            ServletRequest req, 
            ServletResponse res) 
                    throws ServletException, IOException {

        // 여기에서 ServletRequest와 ServletResponse를
        // HttpServletRequest와 HttpServletResponse로 타입 캐스팅 한다.
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;
        
        this.service(httpReq,httpRes);
        // 서브클래스가 이 클래스를 상속받고 추상메소드를 완성시키면 그 완성시킨 메소드를 호출하라는 의미
    }
    public abstract void service(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException;
}