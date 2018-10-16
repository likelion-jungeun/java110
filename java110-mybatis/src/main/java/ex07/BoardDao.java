package ex07;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao{

    // Mybatis 객체를 사용하기 위해 주입받는다.
    SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(Board board){
        // Mybatis는 autoCommit 기본 값이 false 이다. 따라서 insert 후 comming 해줘야함.
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            int count=sqlSession.insert("boarddao.insert", board);
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }

    public int delete(int no){
        // Mybatis는 autoCommit 기본 값이 false 이다. 따라서 insert 후 comming 해줘야함.
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            int count=sqlSession.insert("boarddao.delete", no);
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }
    
    public List<Board> findAll(HashMap<String, Object> params){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectList("boarddao.findAll", params);
        } finally {
            sqlSession.close();
        }
    }
    
    public Board findByNo(int no){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("boarddao.findByNo",no);
        } finally {
            sqlSession.close();
        }
    }
}