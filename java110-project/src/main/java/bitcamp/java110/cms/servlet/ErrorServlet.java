package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(
            HttpServletRequest request,    
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        

        Exception e = (Exception) request.getAttribute("error");
        String message = (String) request.getAttribute("message");
        String refresh = (String) request.getAttribute("refresh");
        
        if(refresh != null) {
            response.setHeader("Refresh", refresh);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCThtml>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        
        // 페이지 머리말 포함하기
        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);
        
        out.println("<title>매니저 관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>%s</h1>",message);
        out.printf("<p>%s</p>\n", e.getMessage());
        out.println("<p>잠시 기다리면 자동으로 목록페이지로 이동합니다</p>");
        
        // 페이지 꼬리말 포함하기
        rd = request.getRequestDispatcher("/footer");
        rd.include(request, response);
        
        out.println("</body>");
        out.println("</html>");
    }


}