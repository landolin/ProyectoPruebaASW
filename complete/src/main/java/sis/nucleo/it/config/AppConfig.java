package sis.nucleo.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import sis.nucleo.it.dao.PruebaRepository;

@EnableWebMvc
@Configuration
@ComponentScan({ "sis.nucleo.it" })
public class AppConfig extends WebMvcConfigurationSupport {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();

		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");

		return bean;
	}
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSourcePostgresql() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/BDSMART_ERP");
		dataSource.setUsername("postgres");
		dataSource.setPassword("12345678");
		return dataSource;
	}
	/*
	 * @Bean(name = "dataSourceMysql") public DriverManagerDataSource
	 * dataSourceMySql() { DriverManagerDataSource dataSource = new
	 * DriverManagerDataSource();
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost/test");
	 * dataSource.setUsername("userName"); dataSource.setPassword("pwd"); return
	 * dataSource; }
	 */

}