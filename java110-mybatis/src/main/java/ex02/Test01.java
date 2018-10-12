// 주제 : factory method 및 builder 디자인 패턴 적용
package ex02;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Test01 {

    public static void main(String[] args) throws Exception{
     
        MemberDaoFactory factory =new DaoBuilder().build();
        MemberDao memberDao = factory.createMemberDao();
        
        List<Member> list = memberDao.findAll();
        for(Member m : list) {
            System.out.printf("%d, %s %s, %s\n",
                    m.getNo(),
                    m.getName(),
                    m.getEmail(),
                    m.getTel());
        }
        DocumentBuilderFactory factory2 =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2 = factory2.newDocumentBuilder();
        Document doc = builder2.newDocument();
    }
}
