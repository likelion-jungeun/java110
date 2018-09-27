package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@WebServlet("/manager/list")
public class ManagerListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    // 이 메소드가 상속받아서 오버라이드 한 메소드인지 묻기위해서 @Override를 붙인거야 (깐깐하게 검사하기 위해)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        ManagerDao managerDao = (ManagerDao)this.getServletContext()
                                .getAttribute("managerDao");

        List<Manager> list = managerDao.findAll();
        for (Manager m : list) {
            out.printf("%d, %s, %s, %s\n", 
                    m.getNo(),
                    m.getName(), 
                    m.getEmail(),
                    m.getPosition());
        }
    }

}