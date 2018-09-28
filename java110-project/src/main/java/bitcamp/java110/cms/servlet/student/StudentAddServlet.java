package bitcamp.java110.cms.servlet.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Student s = new Student();
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));
        s.setTel(request.getParameter("tel"));

        StudentDao studentDao = (StudentDao) this.getServletContext().getAttribute("studentDao");

     
        try {
            studentDao.insert(s);
            response.sendRedirect("list");
        } catch (Exception e) {
            // 오류 내용을 처리하는 서블릿으로 실행을 위임한다.
            RequestDispatcher rd = request.getRequestDispatcher("/error");
            
            // 위임하기 전에 작업을 수행하는데 필요한 정보를 ServletRequest 보관소에 담아 전달한다.
            request.setAttribute("error", e);
            request.setAttribute("message", "학생 등록 오류!");
            request.setAttribute("refresh", "3;url=list");
            
            // 작업을 위임한다.
            rd.forward(request, response);  
       
        }
    }

}
