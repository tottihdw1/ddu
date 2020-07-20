package myprofile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author hdw
 * @create 2020-07-17-15:08
 * @desc 描述
 */
@Configuration
public class JavaProfileConfig {

    @Bean
    @Profile("dev")
    DataSource devDs(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl("mysql");
        dataSource.setName("root");
        dataSource.setPassword("1111111");
        return dataSource;
    }

    @Bean
    @Profile("prod")
    DataSource proDs(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl("mysql1");
        dataSource.setName("root");
        dataSource.setPassword("222222222");
        return dataSource;
    }

}
