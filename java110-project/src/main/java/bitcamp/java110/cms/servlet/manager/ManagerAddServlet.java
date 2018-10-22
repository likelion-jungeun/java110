package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

@MultipartConfig(maxFileSize=2_000_000)
@WebServlet("/manager/add")
public class ManagerAddServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
                    throws ServletException, IOException {
        
        request.setAttribute("viewUrl", "/manager/form.jsp");
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        // POST 방식?���? ?��?��?�� ?���? ?��?��?��?�� 
        // ?��?�� 메서?���? ?��출하?�� ?��?�� ?��코딩?���? ?��?��줘야 
        // getParameter() ?��출할 ?�� ?��?��?��?���? ?��코딩 ?�� 것이?��.
        request.setCharacterEncoding("UTF-8");
        
        Manager m = new Manager();
        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPosition(request.getParameter("position"));
        
        ApplicationContext iocContainer = 
                (ApplicationContext)this.getServletContext()
                                        .getAttribute("iocContainer");
        ManagerService managerService = 
                iocContainer.getBean(ManagerService.class);
        
        try {
            // ?���? ?��?��?�� 처리
            Part part = request.getPart("file1");
            if (part.getSize() > 0) {
                String filename = UUID.randomUUID().toString();
                part.write(this.getServletContext()
                           .getRealPath("/upload/" + filename));
                m.setPhoto(filename);
            }
            
            managerService.add(m);
            
            // ?���? ?��?�� ?��록에 ?��공했?���?, 
            // 목록 ?��?���?�? ?��?�� ?���??��?���? redirect 명령?�� 보낸?��.
            request.setAttribute("viewUrl", "redirect:list");
            
        } catch(Exception e) {
            
            // ?��?��?���? ?��?�� ?��?��?�� ?��?��?��?��?�� ?��?��?�� ?��보�?? 
            // ServletRequest 보�??��?�� ?��?�� ?��?��?��?��.
            request.setAttribute("error", e);
            request.setAttribute("message", "매니?? ?���? ?���?!");
            request.setAttribute("refresh", "3;url=list");
            
            request.setAttribute("viewUrl", "/error.jsp");
            
            
        }
        
    }
    
}
    
    













    
    
    
    
    
    
    
