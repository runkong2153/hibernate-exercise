package core.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static core.util.HibernateUtil.getSessionFactory;

public interface CoreService {

	private Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	default Transaction beginTransction() {
		return getSession().beginTransaction();
	}

	default void commit() {

	}

	default void rollback() {

	}
}
