package com.johnfnash.learn.drools.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.johnfnash.learn.drools.model.Product;

public class RhsUpdateTest {

	public static void main(String[] args) {
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
	
}
