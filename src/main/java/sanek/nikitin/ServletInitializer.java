package sanek.nikitin;

import javax.activation.DataSource;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NikitinApplication.class);
	}
        
//    @Bean
//    @ConfigurationProperties("spring.datasource")
//    public DataSource dataSource() {
//        return (DataSource) DataSourceBuilder.create().build();
//    }

        

}

