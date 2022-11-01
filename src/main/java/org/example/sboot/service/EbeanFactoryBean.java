package org.example.sboot.service;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<Database> {

  @Autowired
  CurrentUser currentUser;
  
//  @Autowired
//  DataSource dataSource;
  
  @Override
  public Database getObject() throws Exception {

    DatabaseConfig config = new DatabaseConfig();
    config.setName("db");
    config.setCurrentUserProvider(currentUser);

//    // set the spring's datasource and transaction manager.
//    config.setDataSource(dataSource);
//    config.setExternalTransactionManager(new SpringAwareJdbcTransactionManager());

    config.loadFromProperties();

    return DatabaseFactory.create(config);
  }

  @Override
  public Class<?> getObjectType() {
    return Database.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
