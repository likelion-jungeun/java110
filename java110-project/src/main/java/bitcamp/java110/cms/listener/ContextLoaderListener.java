package bitcamp.java110.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java110.cms.AppConfig;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener.contextInitialized() 실행!");
        
        ServletContext sc = sce.getServletContext();

        try {
            ApplicationContext context = 
                    new AnnotationConfigApplicationContext(AppConfig.class);
            
            sc.setAttribute("iocContainer", context);
            
//            System.out.println("------------------------------");
//            
//            // 컨테이너에 들어 있는 객체의 개수와 이름 알아내기
//            int count = context.getBeanDefinitionCount();
//            System.out.printf("bean 개수 = %d\n", count);
//            
//            String[] names = context.getBeanDefinitionNames();
//            for (String name : names) {
//                System.out.printf("=> %s : %s\n", 
//                        name, 
//                        context.getType(name).getName());
//            }
//            
//            System.out.println("------------------------------");
//            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







