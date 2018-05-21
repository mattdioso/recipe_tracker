package recipe.tracker;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="recipe.tracker.repository", repositoryFactoryBeanClass=EnversRevisionRepositoryFactoryBean.class)
@SpringBootApplication
@EnableJpaAuditing
public class RecipeTrackerApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(RecipeTrackerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RecipeTrackerApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean h2ServletRegistrationBean() {
		ServletRegistrationBean regBean = new ServletRegistrationBean(new WebServlet());
		regBean.addUrlMappings("/console/*");
		return regBean;
	}
}