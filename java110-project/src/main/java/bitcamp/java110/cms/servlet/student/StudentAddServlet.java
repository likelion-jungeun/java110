package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
            Student s = new Student();
            StudentDao studentDao = (StudentDao)this.getServletContext()
                                    .getAttribute("studentDao");
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setPassword(request.getParameter("password"));
            s.setSchool(request.getParameter("school"));
            s.setWorking(Boolean.parseBoolean(request.getParameter("working")));
            s.setTel(request.getParameter("tel"));

            response.setContentType("text/plain;charset=UTF-8");
            studentDao.insert(s);
            PrintWriter out =response.getWriter();
            out.println("등록하였습니다.");
    }
    
   
}
