package org.example.sboot.service;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer>, EnvironmentAware {

//  /**
//   * Default to local in memory database.
//   */
//  String profileName = "local";

  @Autowired
  CurrentUser currentUser;

  public EbeanFactoryBean() {
  }

  /**
   * Properties used to configure EbeanServer instance.
   */
  Properties properties = new Properties();

  @Override
  public EbeanServer getObject() throws Exception {

    ServerConfig config = new ServerConfig();
    config.setName("db");
    config.setCurrentUserProvider(currentUser);
    config.loadFromProperties(properties);
    config.loadTestProperties();
    config.setDefaultServer(true);
    config.setRegister(true);

    return EbeanServerFactory.create(config);
  }

  @Override
  public Class<?> getObjectType() {
    return EbeanServer.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

  @Override
  public void setEnvironment(Environment environment) {

    //determineActiveProfile(environment.getActiveProfiles());

    loadProperties((AbstractEnvironment) environment);
  }

//  /**
//   * Determine if this is dev, test or prod database configuration.
//   */
//  private void determineActiveProfile(String[] activeProfiles) {
//
//    for (String profile : activeProfiles) {
//      if ("production".equalsIgnoreCase(profile)) {
//        profileName = "prod";
//
//      } else if ("test".equalsIgnoreCase(profile)) {
//        profileName = "test";
//
//      } else if ("development".equalsIgnoreCase(profile)) {
//        profileName = "dev";
//      }
//    }
//  }

  /**
   * Load into Properties (from Spring PropertySource implementations).
   */
  private void loadProperties(AbstractEnvironment environment) {
    MutablePropertySources propertySources = environment.getPropertySources();
    for (PropertySource propertySource :propertySources) {
      if (propertySource instanceof PropertiesPropertySource) {//MapPropertySource
        properties.putAll(((PropertiesPropertySource) propertySource).getSource());
      }
    }
  }

}
