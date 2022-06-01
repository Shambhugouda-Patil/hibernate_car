package com.ty.car;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestValidateUser {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String sql= "SELECT u FROM User u WHERE u.email=?1 and u.password=?2";
		
		Query query=entityManager.createQuery(sql);
		query.setParameter(1, "chetan@123");
		query.setParameter(2, "chetan111");
		
		List<User> users =query.getResultList();
		
		if(users.size()>0) {
			User user=users.get(0);
			System.out.println(("name is :"+ user.getName()));
			System.out.println("email is :"+user.getEmail());
			System.out.println("gender is:"+user.getGender());
		}else {
			System.out.println("invalid user name or password");
		}
		
	}

}
