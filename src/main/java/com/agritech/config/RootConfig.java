package com.agritech.config;
import org.springframework.context.annotation.*; import org.springframework.jdbc.core.JdbcTemplate; import org.springframework.jdbc.datasource.DriverManagerDataSource; import javax.sql.DataSource;
@Configuration @ComponentScan("com.agritech.service")
public class RootConfig {
 @Bean public DataSource dataSource(){DriverManagerDataSource ds=new DriverManagerDataSource(); ds.setDriverClassName("com.mysql.cj.jdbc.Driver"); ds.setUrl(System.getenv().getOrDefault("DB_URL","jdbc:mysql://localhost:3306/smart_agriculture?useSSL=false&serverTimezone=UTC")); ds.setUsername(System.getenv().getOrDefault("DB_USER","root")); ds.setPassword(System.getenv().getOrDefault("DB_PASSWORD","root")); return ds;}
 @Bean public JdbcTemplate jdbcTemplate(DataSource ds){return new JdbcTemplate(ds);}
}