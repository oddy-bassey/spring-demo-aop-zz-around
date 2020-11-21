package com.java.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addAccount() {
		System.out.println(getClass()+" adding a membership account! \n");
		
		return true;
	}
	
	public int getMemberCode() {
		return 12345;
	}
}

