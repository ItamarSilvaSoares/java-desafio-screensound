package br.com.alura.screensound.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotEnvConfig {
  @Bean
  public static BeanFactoryPostProcessor dotenvProcessor() {
    return a -> {
      Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
      dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
    };
  }
}
