package org.example.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {

    SpringApplication app = new SpringApplication(Application.class);
    app.setShowBanner(false);
    ConfigurableApplicationContext applicationContext = app.run(args);
    String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

    Object props = applicationContext.getBean("serverProperties");

  }
}
