package org.example.sboot.domain.repo;

import io.ebean.Database;
import io.ebean.Finder;

public abstract class BeanFinder<I,T> extends Finder<I,T> {

	protected final Database database;

	public BeanFinder(Class<T> type, Database server) {
		super(type);
		this.database = server;
	}

	@Override
	public Database db() {
		return database;
	}
}
