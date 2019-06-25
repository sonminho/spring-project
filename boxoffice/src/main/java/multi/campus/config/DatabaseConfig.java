package multi.campus.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@PropertySource("classpath:database.properties")
@MapperScan("multi.campus.**.dao")
public class DatabaseConfig {
	@Autowired
	private Environment env; // database.properties ���� ����

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("database.driver"));
		dataSource.setUrl(env.getProperty("database.url"));
		dataSource.setUsername(env.getProperty("database.username"));
		dataSource.setPassword(env.getProperty("database.password"));

		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setTypeAliasesPackage("multi.campus.domain");
		sessionFactory
				.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		// MyBatis ����
		org.apache.ibatis.session.Configuration config = sessionFactory.getObject().getConfiguration();
		config.setMapUnderscoreToCamelCase(true);
		config.setCacheEnabled(false);
		return sessionFactory.getObject();
	}
}
