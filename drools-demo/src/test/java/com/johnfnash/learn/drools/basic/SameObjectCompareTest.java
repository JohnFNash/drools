package com.johnfnash.learn.drools.basic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.johnfnash.learn.drools.model.Customer;

public class SameObjectCompareTest {

	@Test
	public void test1() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("objCompare1-rules");
		
		Customer customer = new Customer();
		customer.setAge(61);
		kSession.insert(customer);
		
		Customer customer1 = new Customer();
		customer1.setAge(59);
		kSession.insert(customer1);

		int count = kSession.fireAllRules();
		kSession.dispose();
		
		 System.out.println("Fire " + count + " rules!");
	}
	
	@Test
	public void test2() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("objCompare2-rules");
		
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		customer.setAge(61);
		customers.add(customer);
		
		Customer customer1 = new Customer();
		customer1.setAge(59);
		customers.add(customer1);
		
		kSession.insert(customers);
		
		int count = kSession.fireAllRules();
		kSession.dispose();
		
		 System.out.println("Fire " + count + " rules!");
	}
	
}
