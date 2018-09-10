package bitcamp.java110.cms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*애노테이션 유지 정책 3가지 (유지정책의 default값은 CLASS임!!)
 * CLASS : 컴파일을 한 후 .class에 남겨둔다. 단, 실행할 때는 참조할 수 없다. 
           -> Reflection API로 클래스 파일에서 애노테이션 정보를 추출할 수 없다.
 * SOURCE : 컴파일할 때 제거된다. 즉, .class 파일에 남겨두지 않는다.
 * RUNTIME : 컴파일 한 후에 .class 파일에 남겨둔다. 단, 실행할 때에도 참조할 수 있다.
 *          -> Reflection API로 클래스에서 애노테이션 정보를 추출할 수 있다는 의미.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    // 일반적으로 메소드는 동사로 작성.(애노테이션에는 명사로) => 필드명을 가진 프라퍼티(getter, setter같은것)
    String value() default "";

}
