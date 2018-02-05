package com.wei.springboottucao.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.wei.springboottucao")
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@PropertySource({ "classpath:dataConfig.properties" })
@Profile(value = "prod")
public class DataBaseConfig {

	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource oBasicDataSource = new BasicDataSource();
		oBasicDataSource.setDriverClassName(env.getProperty("MySQL.driverClassName"));
		oBasicDataSource.setUrl(env.getProperty("MySQL.url"));
		oBasicDataSource.setUsername(env.getProperty("MySQL.userName"));
		oBasicDataSource.setPassword(env.getProperty("MySQL.password"));
		return oBasicDataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.wei");
		factory.setDataSource(dataSource());
		Properties props = new Properties();
		props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		props.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		// props.put("javax.persistence.schema-generation.database.action",
		// "create"); //设置数据库的动作
		// props.put("javax.persistence.schema-generation.create-source",
		// "metadata");//创建数据的方式，可以是通过实体类来创建，通过sql脚步创建，或者两者结合
		// props.put("javax.persistence.schema-generation.scripts.create-target",
		// "init.sql");//创建数据库的脚步路径
		// props.put("javax.persistence.sql-load-script-source",
		// env.getProperty("hibernate.init.sql"));//初始化数据库的脚步
		// props.put("javax.persistence.schema-generation.scripts.action",
		// "create");//设置数据库脚步相关动作
		// props.put("javax.persistence.schema-generation.scripts.create-target",
		// "create.sql");//设置输出脚步的路径
		factory.setJpaProperties(props);
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

}
