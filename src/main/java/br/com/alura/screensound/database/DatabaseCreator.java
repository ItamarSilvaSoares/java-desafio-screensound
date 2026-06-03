package br.com.alura.screensound.database;

import br.com.alura.screensound.exceptions.ProprietiesNotFound;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DatabaseCreator implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {

    Environment env = beanFactory.getBean(Environment.class);

    DatabaseProperties props =
        Binder.get(env)
            .bind("app.database", DatabaseProperties.class)
            .orElseThrow(ProprietiesNotFound::new);

    String adminUrl = String.format("jdbc:postgresql://%s:%d/postgres", props.host(), props.port());

    try (Connection conn =
        DriverManager.getConnection(adminUrl, props.username(), props.password())) {

      ResultSet rs =
          conn.createStatement()
              .executeQuery("SELECT 1 FROM pg_database WHERE datname = '" + props.name() + "'");

      if (!rs.next()) {
        try (Statement stmt = conn.createStatement()) {
          stmt.execute("CREATE DATABASE " + props.name());
        }
      }

    } catch (Exception e) {
      throw new RuntimeException("Erro ao verificar/criar banco de dados", e);
    }
  }
}
