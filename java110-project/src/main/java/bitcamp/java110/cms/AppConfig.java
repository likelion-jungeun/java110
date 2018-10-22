package bitcamp.java110.cms;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ComponentScan(basePackages="bitcamp.java110.cms")
@PropertySource("classpath:/bitcamp/java110/cms/conf/jdbc.properties")

// Mybatis?—?„œ ?ž?™?œ¼ë¡? DAOë¥? ?ƒ?„±?•  ?•Œ ?‚¬?š©?•  ?¸?„°?Ž˜?´?Š¤ê°? ?“¤?–´ ?žˆ?Š” ?Œ¨?‚¤ì§? ?„¤? • 
@MapperScan("bitcamp.java110.cms.dao")
public class AppConfig {
    
    @Autowired
    Environment env;
    
    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        System.out.println("DataSource ê°ì²´ ?ƒ?„±!");
        
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driver"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        ds.setDefaultAutoCommit(false);
        
        return ds;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(
            DataSource dataSource,
            ApplicationContext appCtx) {
        System.out.println("SqlSessionFactory ê°ì²´ ?ƒ?„±!");
        
        try {
            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
            
            // DB ì»¤ë„¥?…˜???„ ê´?ë¦¬í•´ì£¼ëŠ” ê°ì²´ë¥? ê¼½ëŠ”?‹¤.
            factory.setDataSource(dataSource);
            
            // SQL ë§µí¼ ?ŒŒ?¼?—?„œ ?„ë©”ì¸ ê°ì²´?˜ ë³„ëª…?„ ?‚¬?š©?•˜? ¤ë©? 
            // ?„ë©”ì¸ ê°ì²´ê°? ?“¤?–´ ?žˆ?Š” ?Œ¨?‚¤ì§?ë¥? ì§?? •?•´?•¼ ?•œ?‹¤. 
            // ê·¸ëŸ¬ë©? Mybatisê°? ?•´?‹¹ ?Œ¨?‚¤ì§??˜ ëª¨ë“  ?´?ž˜?Š¤?— ???•´ ë³„ëª…?„ ?ž?™?œ¼ë¡? ?ƒ?„±?•  ê²ƒì´?‹¤.
            factory.setTypeAliasesPackage("bitcamp.java110.cms.domain");
            
            // SQL ë§µí¼ ?ŒŒ?¼ ê²½ë¡œë¥? ?“±ë¡í•œ?‹¤.
            factory.setMapperLocations(appCtx.getResources(
                    "classpath:/bitcamp/java110/cms/mapper/**/*.xml"));
            
            return factory.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e); 
        }
    }

/*
    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        System.out.println("------------------------------");
        
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean ê°œìˆ˜ = %d\n", count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        
        System.out.println("------------------------------");
        
        
        ManagerService s = 
                (ManagerService) iocContainer.getBean(ManagerService.class);
        System.out.println(s.list(1, 5));
        
        
        Properties props = System.getProperties();
        Set<Entry<Object,Object>> entrySet = props.entrySet();
        for (Entry entry : entrySet) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue()); 
        }
    } 
*/
}














