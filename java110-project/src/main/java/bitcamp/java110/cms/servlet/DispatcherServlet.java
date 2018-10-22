package bitcamp.java110.cms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.web.PageController;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // ?��?��?��?��?���? ?���??�� URL?��?�� /app ?��?��?�� �??��?�� 경로�? 추출?��?��.
        String pageControllerPath = request.getPathInfo();
        
        // ?��?���? IoC 컨테?��?�� �??��?���?
        ApplicationContext iocContainer = 
                (ApplicationContext)this.getServletContext()
                                        .getAttribute("iocContainer");
        
        try {
            // IoC 컨테?��?��?��?�� ?��?���? 컨트롤러�? 찾는?��.
            PageController controller = 
                (PageController) iocContainer.getBean(pageControllerPath);
            
            // PageController ?��?��
            String viewUrl = controller.service(request, response);
            
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
                
            } else {
                // ?��?���? 컨트롤러�? �??��?�� URL?�� ?��?��
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher rd = 
                        request.getRequestDispatcher(viewUrl);
                rd.include(request, response);
            }
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "?��?�� ?���?!");

            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd = 
                    request.getRequestDispatcher("/error.jsp");
            rd.include(request, response);
        }
    }
}














