package com.coforge.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

public class DBOperations {
	private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

	public static void main(String[] args) {
		DBOperations db = new DBOperations();
		  db.insertItems();
		//db.fetchItems();
		//db.updateItemName();
		//db.fetchItems();
		//db.deleteItem();
		//db.fetchItems();
		//db.fetchItemsByCriteria();
		//db.fetchItemsByNamedQuery();
	}

	// Insert a new item
	public void insertItems() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Item item = new Item();
		item.setItemName("Mobile");
		item.setPrice(45000.0);

		session.save(item);
		tx.commit();
	}

	// Fetch items by id using HQL
	public void fetchItems() {
		Session session = sessionFactory.openSession();
		Query<Item> query = session.createQuery("from Item where id = :id", Item.class);
		query.setParameter("id", 2);

		List<Item> items = query.list();
		System.out.println("Items fetched: " + items);
	}

	// Update item name by id
	public void updateItemName() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("update Item set itemName = :name where id = :id");
		query.setParameter("name", "Washing Machine");
		query.setParameter("id", 2);

		int result = query.executeUpdate();
		tx.commit();
		System.out.println("Number of items updated: " + result);
	}

	// Delete an item by id
	public void deleteItem() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("delete from Item where id = :id");
		query.setParameter("id", 2);

		int result = query.executeUpdate();
		tx.commit();
		System.out.println("Number of items deleted: " + result);
	}

	// Fetch items using Criteria API
	public void fetchItemsByCriteria() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
		Root<Item> root = criteriaQuery.from(Item.class);

		// Cast the Path to String
		Path<String> itemNamePath = root.get("itemName");
		criteriaQuery.select(itemNamePath);

		List<String> itemNames = session.createQuery(criteriaQuery).getResultList();
		System.out.println("Item names fetched: " + itemNames);
	}

	// Fetch items by named query
	public void fetchItemsByNamedQuery() {
		Session session = sessionFactory.openSession();
		Query<Item> query = session.createNamedQuery("fetchItemsById", Item.class);
		query.setParameter("id", 3);

		List<Item> items = query.list();
		System.out.println("Items fetched by named query: " + items);
	}
}
