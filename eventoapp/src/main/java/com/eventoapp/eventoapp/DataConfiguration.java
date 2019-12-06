package com.eventoapp.eventoapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration//Mostrando para o Spring que ela é uma classe de configuração.
public class DataConfiguration {
    
	@Bean
	public DataSource dataSource() {//Esse e o nosso Bean de conexão com o banco.
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
		
		}
	@Bean
    public JpaVendorAdapter jpaVendorAdapter() {
    	
    	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    	adapter.setDatabase(Database.MYSQL);
    	adapter.setShowSql(true);//Quando inserir um dado ele aparece passo a paaso no console.
    	adapter.setGenerateDdl(true);//Permite que o Hibernate crie as tabelas automaticamente.
    	adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
    	adapter.setPrepareConnection(true);//Para o hibernate preparar a conexao automaticamente.
    	return adapter;
    }
}