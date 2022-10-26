package org.example.sboot.domain.repo;

import io.ebean.Database;
import org.example.sboot.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContentRepository extends BeanRepository<Long,Content> {

	@Autowired
	public ContentRepository(Database database) {
		super(Content.class, database);
	}

}
