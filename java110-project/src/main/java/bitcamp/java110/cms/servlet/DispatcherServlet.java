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
        
        // ?Å¥?ùº?ù¥?ñ∏?ä∏Í∞? ?öîÏ≤??ïú URL?óê?Ñú /app ?ã§?ùå?óê Ïß??†ï?ïú Í≤ΩÎ°úÎ•? Ï∂îÏ∂ú?ïú?ã§.
        String pageControllerPath = request.getPathInfo();
        
        // ?ä§?îÑÎß? IoC Ïª®ÌÖå?ù¥?Ñà Í∞??†∏?ò§Í∏?
        ApplicationContext iocContainer = 
                (ApplicationContext)this.getServletContext()
                                        .getAttribute("iocContainer");
        
        try {
            // IoC Ïª®ÌÖå?ù¥?Ñà?óê?Ñú ?éò?ù¥Ïß? Ïª®Ìä∏Î°§Îü¨Î•? Ï∞æÎäî?ã§.
            PageController controller = 
                (PageController) iocContainer.getBean(pageControllerPath);
            
            // PageController ?ã§?ñâ
            String viewUrl = controller.service(request, response);
            
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
                
            } else {
                // ?éò?ù¥Ïß? Ïª®Ìä∏Î°§Îü¨Í∞? Ïß??†ï?ïú URL?ùÑ ?ã§?ñâ
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher rd = 
                        request.getRequestDispatcher(viewUrl);
                rd.include(request, response);
            }
            
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("message", "?ã§?ñâ ?ò§Î•?!");

            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd = 
                    request.getRequestDispatcher("/error.jsp");
            rd.include(request, response);
        }
    }
}














