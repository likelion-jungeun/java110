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
        
        // POST ë°©ì‹?œ¼ë¡? ?“¤?–´?˜¨ ?•œê¸? ?°?´?„°?Š” 
        // ?‹¤?Œ ë©”ì„œ?“œë¥? ?˜¸ì¶œí•˜?—¬ ?–´?–¤ ?¸ì½”ë”©?¸ì§? ?•Œ? ¤ì¤˜ì•¼ 
        // getParameter() ?˜¸ì¶œí•  ?•Œ ? •?ƒ? ?œ¼ë¡? ?””ì½”ë”© ?•  ê²ƒì´?‹¤.
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
            // ?‚¬ì§? ?°?´?„° ì²˜ë¦¬
            Part part = request.getPart("file1");
            if (part.getSize() > 0) {
                String filename = UUID.randomUUID().toString();
                part.write(this.getServletContext()
                           .getRealPath("/upload/" + filename));
                m.setPhoto(filename);
            }
            
            managerService.add(m);
            
            // ?˜¤ë¥? ?—†?´ ?“±ë¡ì— ?„±ê³µí–ˆ?œ¼ë©?, 
            // ëª©ë¡ ?˜?´ì§?ë¥? ?‹¤?‹œ ?š”ì²??•˜?¼ê³? redirect ëª…ë ¹?„ ë³´ë‚¸?‹¤.
            request.setAttribute("viewUrl", "redirect:list");
            
        } catch(Exception e) {
            
            // ?œ„?„?•˜ê¸? ? „?— ?‘?—…?„ ?ˆ˜?–‰?•˜?Š”?° ?•„?š”?•œ ? •ë³´ë?? 
            // ServletRequest ë³´ê??†Œ?— ?‹´?•„ ? „?‹¬?•œ?‹¤.
            request.setAttribute("error", e);
            request.setAttribute("message", "ë§¤ë‹ˆ?? ?“±ë¡? ?˜¤ë¥?!");
            request.setAttribute("refresh", "3;url=list");
            
            request.setAttribute("viewUrl", "/error.jsp");
            
            
        }
        
    }
    
}
    
    













    
    
    
    
    
    
    
