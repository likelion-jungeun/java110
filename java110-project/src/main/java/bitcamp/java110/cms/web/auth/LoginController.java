package bitcamp.java110.cms.servlet.auth;
 
import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.service.AuthService;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        request.setAttribute("viewUrl", "/auth/form.jsp");
       
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {

        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String save = request.getParameter("save");
        
        ArrayList<Cookie> cookies = new ArrayList<>();
        
        if (save != null) {// ?��메일 ???��?��기�?? 체크?��?���?,
            Cookie cookie = new Cookie("email", email);
            cookie.setMaxAge(60 * 60 * 24 * 15);
            cookies.add(cookie);
            
        } else {// ?��메일?�� ???��?���? ?���? ?��?���?,
            Cookie cookie = new Cookie("email", "");
            cookie.setMaxAge(0);
            cookies.add(cookie);
        }
        
        ApplicationContext iocContainer = 
                (ApplicationContext)this.getServletContext()
                                        .getAttribute("iocContainer");
        AuthService authService = iocContainer.getBean(AuthService.class);
        
        Member loginUser = authService.getMember(email, password, type);
        
        HttpSession session = request.getSession();
        if (loginUser != null) {
            // ?��?�� ?��보�?? ?��?��?�� 보�??��?��.
            session.setAttribute("loginUser", loginUser);
            String redirectUrl = null;
            
            switch (type) {
            case "student":
                redirectUrl = "../student/list";
                break;
            case "teacher":
                redirectUrl = "../teacher/list";
                break; 
            case "manager":
                redirectUrl = "../manager/list";
                break; 
            }
            request.setAttribute("viewUrl", "redirect:"+redirectUrl);
            
        } else {
            // 로그?�� ?�� ?��?��?��?�� ?���? ?��?��?���? 로그?��?�� ?��?��?��?���? 
            // ?��?��?��?���? 무조�? ?��?��?�� 무효?��?��?��?��.
            session.invalidate();
            request.setAttribute("viewUrl", "redirect:login");
        }
        
        request.setAttribute("cookies", cookies);
    }
}














