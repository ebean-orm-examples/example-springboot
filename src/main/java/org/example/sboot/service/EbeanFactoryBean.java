package org.example.sboot.service;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.CurrentUserProvider;
import io.ebean.config.ServerConfig;
import org.example.sboot.domain.Content;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import io.ebean.springsupport.txn.SpringAwareJdbcTransactionManager;

/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

  @Autowired
  CurrentUser currentUser;
  
//  @Autowired
//  DataSource dataSource;
  
  @Override
  public EbeanServer getObject() throws Exception {

    ServerConfig config = new ServerConfig();
    config.setName("db");
    config.setCurrentUserProvider(() -> "test");

//    // set the spring's datasource and transaction manager.
//    config.setDataSource(dataSource);
//    config.setExternalTransactionManager(new SpringAwareJdbcTransactionManager());

    config.loadFromProperties();
    config.loadTestProperties();

//    config.addClass(Content.class);

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
}
