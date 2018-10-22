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

// Mybatis?? ???Όλ‘? DAOλ₯? ??±?  ? ?¬?©?  ?Έ?°??΄?€κ°? ?€?΄ ?? ?¨?€μ§? ?€?  
@MapperScan("bitcamp.java110.cms.dao")
public class AppConfig {
    
    @Autowired
    Environment env;
    
    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        System.out.println("DataSource κ°μ²΄ ??±!");
        
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
        System.out.println("SqlSessionFactory κ°μ²΄ ??±!");
        
        try {
            SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
            
            // DB μ»€λ₯???? κ΄?λ¦¬ν΄μ£Όλ κ°μ²΄λ₯? κΌ½λ?€.
            factory.setDataSource(dataSource);
            
            // SQL λ§΅νΌ ??Ό?? ?λ©μΈ κ°μ²΄? λ³λͺ? ?¬?©?? €λ©? 
            // ?λ©μΈ κ°μ²΄κ°? ?€?΄ ?? ?¨?€μ§?λ₯? μ§?? ?΄?Ό ??€. 
            // κ·Έλ¬λ©? Mybatisκ°? ?΄?Ή ?¨?€μ§?? λͺ¨λ  ?΄??€? ???΄ λ³λͺ? ???Όλ‘? ??±?  κ²μ΄?€.
            factory.setTypeAliasesPackage("bitcamp.java110.cms.domain");
            
            // SQL λ§΅νΌ ??Ό κ²½λ‘λ₯? ?±λ‘ν?€.
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
        System.out.printf("bean κ°μ = %d\n", count);
        
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














