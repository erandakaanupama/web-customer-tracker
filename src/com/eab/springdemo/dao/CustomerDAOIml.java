package com.eab.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eab.springdemo.entity.Customer;

@Repository
public class CustomerDAOIml implements CustomerDAO {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

		// exec query
		List<Customer> customers = theQuery.getResultList();

		// return results
		return customers;
	}

}
