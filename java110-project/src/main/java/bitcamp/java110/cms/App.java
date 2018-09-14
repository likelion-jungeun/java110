package bitcamp.java110.cms;
import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {
    
    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        //Spring IoC 컨테이너 사용
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java110/cms/conf/application-context.xml");
        
        //Ioc 컨테이너 생성한 객체 조회하기
        System.out.println("----------------------");
        String[] names= iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            System.out.println(name);
        }
        System.out.println("----------------------");
        
        RequestMappingHandlerMapping requestHandlerMap = 
                new RequestMappingHandlerMapping();
        
        // => IoC 컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[] nameList = iocContainer.getBeanDefinitionNames();
        for (String name : nameList) {
            Object obj = iocContainer.getBean(name);
           
            requestHandlerMap.addMapping(obj);
        }
        
        while (true) {
            String menu = prompt();
            if (menu.equals("exit")){
                System.out.println("안녕히 가세요!");
                break;
            } 
            
            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);
            if (mapping == null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
            
            try {
                mapping.getMethod().invoke(mapping.getInstance(), keyIn);
            } catch (Exception e) {
                System.out.println("실행 오류!");
                System.out.println(e.getCause());
            }
        }
        
        keyIn.close();
        iocContainer.close();
    }

    private static String prompt() {
        System.out.print("메뉴> ");
        return keyIn.nextLine();
    }
}






















