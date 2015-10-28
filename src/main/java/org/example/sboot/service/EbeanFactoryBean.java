package org.example.sboot.service;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer>, EnvironmentAware {

  @Autowired
  CurrentUser currentUser;

  /**
   * Properties used to configure EbeanServer instance
   * (loaded from spring boot application properties).
   */
  Properties properties = new Properties();

  public EbeanFactoryBean() {
  }

  @Override
  public EbeanServer getObject() throws Exception {

    ServerConfig config = new ServerConfig();
    config.setName("db");
    config.setCurrentUserProvider(currentUser);
    config.loadFromProperties(properties);

    // If entity beans are in a separate jar then name the
    // jars that should be scanned using addJar()
    //config.addJar("example-domain");

    // load test-ebean.properties if present for running tests
    // typically using H2 in memory database
    config.loadTestProperties();

    // set as default and register so that Model can be
    // used if desired for save() and update() etc
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

    loadProperties((AbstractEnvironment) environment);
  }


  /**
   * Load into Properties (from Spring PropertySource implementations).
   */
  private void loadProperties(AbstractEnvironment environment) {

    MutablePropertySources propertySources = environment.getPropertySources();

    // reverse the order of the property sources
    List<MapPropertySource> props = new ArrayList<>();
    for (PropertySource propertySource :propertySources) {
      if (propertySource instanceof MapPropertySource) {
        props.add(0, (MapPropertySource) propertySource);
      }
    }
    // merge them into the single Properties
    for (MapPropertySource propertySource : props) {
      properties.putAll(propertySource.getSource());
    }
  }

}
