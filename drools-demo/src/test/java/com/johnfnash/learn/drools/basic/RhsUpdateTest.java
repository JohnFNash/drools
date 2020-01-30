package com.johnfnash.learn.drools.basic;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.johnfnash.learn.drools.model.Dog;
import com.johnfnash.learn.drools.model.MyData;
import com.johnfnash.learn.drools.model.Product;

public class RhsUpdateTest {

	@Test
	public void test() {
		KieServices kieServices = KieServices.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("rhs-update-rules");
		
		Product product = new Product();
		product.setDiscount(1);
		kieSession.insert(product);
		
		int count = kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("Fire " + count + " rules!");
	}
	
	@Test
	public void test2() {
		KieServices kieServices = KieServices.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("updateExtend-rules");
		
		Dog dog = new Dog();
		dog.setAge(0);
		
		MyData myData = new MyData();
		myData.setMyDog(dog);
		
		kieSession.insert(dog);
		kieSession.insert(myData);
		
		int count = kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("Fire " + count + " rules!");
	}
	
}
