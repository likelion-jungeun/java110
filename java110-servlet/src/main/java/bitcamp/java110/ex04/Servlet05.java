/*
 * 클라이언트가 보낸 데이터 읽기 - POST 요청으로 보낸 한글이 깨지는 문제를 해결
 */
package bitcamp.java110.ex04;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/ex04/servlet05")
public class Servlet05 extends GenericServlet{

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {


        // 테스트 :
        // => http://localhost:8888/ex04/post2.html 페이지에서 값을 입력한 후 보내기 버튼을 클릭한다.
        //

        // => 클라이언트가 보낸 데이터가 어떤 문자표로 인코딩 되었는지 알려준다.
        //    만약, 알려주지 않으면 ISO-8859-1로 인코딩되엇다고 간주한다.
        //    즉, 클라이언트가 보낸 데이터가 모두 영문이나 숫자라고 간주하고 각 바이트 앞에 00 1바이트를 붙여
        //    Unicode로 변환한다. 그래서 한글의 경우 잘못 변환되어 깨지는 것이다.
        // => 주의! 
        //    getParameter()를 단 한번이라도 호출하기 전에, 먼저 설정해야한다.
        //    그 이후에 설정한다면 적용되지 않는다.
        // => 초보 개발자가 많이 놓치는 예 :
        //    서블릿 앞에 필터를 꼽고 그 필터에서 getParameter()를 호출한 경우,
        //    이미 getParameter()를 호출했기 때문에 서블릿에서 setCharacterEncoding()을 호출해봐야 소용x
        //    그런데, 개발자는 필터에서 getParameter()를 호출한 줄도 모르고, 왜안되지? 라고 황당해한다.
        req.setCharacterEncoding("UTF-8");

        int age= Integer.parseInt(req.getParameter("age"));
        boolean working = Boolean.parseBoolean(req.getParameter("working"));
        
        String name= req.getParameter("name");
    
        res.setContentType("text/plain;charset=UTF-8");

        PrintWriter out = res.getWriter();
        out.printf("name=%s \n",name);
        out.printf("age=%d \n",age);
        out.printf("working=%b \n",working);
    }
}

// POST 요청
// => POST 요청으로 값을 보내기 위해서는 [message-body]에 붙여 보내야 한다.
//
/*
POST /ex04/servlet02 HTTP/1.1
Host: localhost:8888
Connection: keep-alive
Content-Length: 31
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8888
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*;q=0.8
Referer: http://localhost:8888/ex04/form.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Cookie: JSESSIONID=1DDE063832C610B56121BD91B3BA19CD
 */

// POST 요청의 특징
// - message-body 영역에 데이터를 포함시킨다.
//   => URL에 데이터가 포함되어 있지 않다.
//   =>` 즐겨찾기에는 URL만 저장되기 때문에 데이터가 포함되지 않은 URL을 저장해봐야 소용없다.
//   => 그래서 데이터 조회화면을 요청할 때는 POST 방식을 사용하지 않는다.
// - 보안
//   => URL에 데이터가 포함되어 있지 않기 때문에 데이터가 노출되지 말아야 할 경우(예- 로그인, 회원가입 등)에 적합하다.
// - 대용량 데이터
//   => 대부분의 웹 서버는 request-uri 또는 헤더를 포함한 메타 데이터의 크기를 8KB 미만으로 설정하고 있다.
//      그러나, message-body 영역은 제한을 두지 않거나 큰 용량을 허락하고 있다.
//   => 그래서 대용량 데이터를 보낼 때는 POST 방식을 사용한다.
// - 바이너리 데이터 전송
//   => message-body 부분에 첨부하기 때문에 바이너리 데이터를 전송할 수 있다.
//      단, 멀티파트 형식으로 보낸다.
// - 적용부분
//   => 로그인, 회원가입 처럼 데이터가 캐시에 보관되거나 노출되지 말아야하는 경우 
//   => 게시글 등록/변경 처럼 대용량의 데이터를 전송해야 하는 경우
//   => 파일 업로드처럼 바이너리 데이터를 전송해야 하는 경우