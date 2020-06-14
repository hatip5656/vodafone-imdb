package com.vodafone.imdb;

import org.mapstruct.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@SpringBootApplication
@EnableSwagger2
public class ImdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}

	@Bean
	public Docket docApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.vodafone.imdb"))
				.paths(PathSelectors.any())
				.build();

	}
	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.addScript(new ClassPathResource("/data.sql"));
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
		return dataSourceInitializer;
	}
}
