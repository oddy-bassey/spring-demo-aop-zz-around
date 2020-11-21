package com.java.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	//add a new method: findAccounts()
	public List<Account> findAccounts(boolean tripWire){
		
		//for academic purpose...simulate an exception
		if(tripWire) {
			throw new RuntimeException("Not running this code");
		}
		
		List<Account> accounts = new ArrayList<Account>();
		
		//create sample accounts
		Account acc1 = new Account("John", "silver");
		Account acc2 = new Account("James", "brone");
		Account acc3 = new Account("Richards", "diamond");
		
		//add accounts to list
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);
		
		return accounts;
	}
	
	public String getName() {
		System.out.println(getClass()+" in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+" in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+" in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	
	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass()+"adding an account \n");
	}
	
	public String personAccount() {
		return "@revoltcode";
	}
}
