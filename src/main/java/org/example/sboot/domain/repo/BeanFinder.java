package org.example.sboot.domain.repo;

import io.ebean.EbeanServer;
import io.ebean.Finder;

public abstract class BeanFinder<I,T> extends Finder<I,T> {

	protected final EbeanServer server;

	public BeanFinder(Class<T> type, EbeanServer server) {
		super(type);
		this.server = server;
	}

	@Override
	public EbeanServer db() {
		return server;
	}
}
