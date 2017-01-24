package com.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.entity.User;

public class UserDAOTest {

	@Test
	public void testGetAllUsers() {
		ArrayList<User> usersList = UserDAO.getAllUsers();
		Iterator<User> usersListIterator = usersList.iterator();
		User eachUser;
		while (usersListIterator.hasNext()) {
			eachUser = (User) usersListIterator.next();
			System.out.println(eachUser);
		}
	}

	/**
	 * sysout user info whose id=2.
	 */
	@Test
	public void testGetUserById() {
		System.out.println(UserDAO.getUserById(2));
	}

	@Test
	public void testGetUserByName() {
		System.out.println(UserDAO.getUserByName("user2"));
	}
	
	@Test
	public void testTryLogin() {
		assertTrue(UserDAO.tryLogin("user1", "111"));
		//assertTrue(UserDAO.tryLogin("user1", "222"));
		//assertTrue(UserDAO.tryLogin("user10", "111"));
	}
}
