package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/manager/list")
public class ManagerListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ManagerMysqlDao managerDao;

    // httpServlet을 상속받는 경우에는 init()이 두개 뜸. 이때 굳이 init(ServletCOnfig config)를
    // 쓸 필요없음. 왜냐? 어차피 그 오버라이딩한 init(Servlet~)이 init()을 호출하니깐.
    @Override
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        managerDao = new ManagerMysqlDao();
        managerDao.setDataSource(dataSource);
    }

    // 이 메소드가 상속받아서 오버라이드 한 메소드인지 묻기위해서 @Override를 붙인거야 (깐깐하게 검사하기 위해)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Manager> list = managerDao.findAll();
        for (Manager m : list) {
            out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getPosition());
        }
    }

}