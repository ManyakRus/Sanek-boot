package sanek.nikitin;

import javax.activation.DataSource;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@SpringBootApplication
//@Resource(name="Mysql", type=javax.sql.DataSource.class, lookup="Mysql")
public class NikitinApplication {

    public static void main(String[] args) {
        SpringApplication.run(NikitinApplication.class, args);
    }

//    @Bean
//    @ConfigurationProperties("spring.datasource")
//    public DataSource dataSource() {
//        return (DataSource) DataSourceBuilder.create().build();
//    }

//    @Bean
//    public DataSource dataSource() {
//        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//        DataSource dataSource = (DataSource) dataSourceLookup.getDataSource("Mysql");
//        return dataSource;
//    }
}
