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

@WebServlet("/student/detail")
public class StudentDetailServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");
        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");
        int no = Integer.parseInt(request.getParameter("no"));
        Student s = studentDao.findByNo(no);

        PrintWriter out = response.getWriter();
        if (s == null) {
            out.println("해당 번호의 학생 정보가 없습니다!");
            return;
        }

        out.printf("이름: %s\n", s.getName());
        out.printf("이메일: %s\n", s.getEmail());
        out.printf("암호: %s\n", s.getPassword());
        out.printf("최종학력: %s\n", s.getSchool());
        out.printf("전화: %s\n", s.getTel());
        out.printf("재직여부: %b\n", s.isWorking());
    }


}
