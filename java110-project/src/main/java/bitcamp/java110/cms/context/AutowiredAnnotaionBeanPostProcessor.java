package bitcamp.java110.cms.context;

import java.lang.reflect.Method;
import java.util.Collection;

import bitcamp.java110.cms.annotation.Autowired;

//autowiredAnnotatin을 처리할건데 bean이 생성된 후에 처리할 놈이다!

public class AutowiredAnnotaionBeanPostProcessor {

    ApplicationContext beanContainer;

    public void postProcess(ApplicationContext beanContainer) {

        // objPool에 보관된 객체 목록을 꺼낸다.
        Collection<Object> objList = beanContainer.objPool.values();

        for (Object obj : objList) {

            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method m : methods) {
                if (!m.isAnnotationPresent(Autowired.class))
                    continue;
                // setter 메서드의 파라미터 타입을 알아낸다.
                Class<?> paramType = m.getParameterTypes()[0];

                // 그 파라미터 타입과 일치하는 객체가 objPool에서 꺼낸다.
                Object dependency = beanContainer.getBean(paramType);

                if (dependency == null)
                    continue;

                try {
                    m.invoke(obj, dependency);
                    System.out.printf("%s() 호출됨\n", m.getName());
                } catch (Exception e) {
                }
            }
        }

    }

}
