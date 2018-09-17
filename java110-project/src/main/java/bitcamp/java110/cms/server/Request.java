package bitcamp.java110.cms.server;

import java.util.HashMap;
import java.util.Map;

public class Request {

    // 명령어를 주면 그 명령어를 저장함 (생성자)
    String command; // 명령어
    String AppPath; //앞부분에 있는 명령어
    String queryString; //뒷부분에 있는 명령어
    Map<String, String> paramMap= new HashMap<>();

    public Request(String command) {
        this.command = command;

        // 근데 단순히 저장만 하는게 아님. 명령어에서 Query String을 분리한다.
        //ex) manager/add?name=aaa&email=aaa@test.com&password=1111
        //물음표를 기준으로 나누는데 앞부분이 실제 메소드를 실행할 경로임
        String[] values = command.split("\\?"); // 물음표로 나눔
        this.AppPath=values[0]; //manager/add (물음표 앞부분)
        if (values.length >= 2) {//2 이상이라는건 문자열 사이에 물음표가 있어서 두개로 쪼개져있다는거임
            queryString = values[1]; //name=aaa&email=aaa@test.com&password=1111(물음표 뒷부분)
     
            parseQueryString(queryString);
        }
    }
  
    private void parseQueryString(String qs) {

        String[] values = qs.split("&");
        for(String value : values) {

            String[] kv= value.split("=");
            paramMap.put(kv[0], kv[1]);
        }
    }
    
    public String getParameter(String name) {
        return this.paramMap.get(name);
    }

    public String getCommand() { //전체 명령어를 리턴하는 메소드
        return this.command;
    }
    
    public String getAppPath() { //물음표 앞 값만 알고싶을 때 사용하는 메소드
        return this.AppPath;
    }

    public String getQueryString() {
        return this.queryString;
    }
    
}
