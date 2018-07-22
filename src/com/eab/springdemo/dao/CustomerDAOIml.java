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
	public List<Customer> getCustomers() {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// exec query
		List<Customer> customers = theQuery.getResultList();

		// return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// save/update customer
		session.saveOrUpdate(customer);

	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current session
		Session session = sessionFactory.getCurrentSession();

		// delete customer
		/*
		 * Customer customer = session.get(Customer.class, theId);
		 * session.delete(customer);
		 */

		// create query
		Query<Customer> theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		// execute query
		theQuery.executeUpdate();
		
	}

}
