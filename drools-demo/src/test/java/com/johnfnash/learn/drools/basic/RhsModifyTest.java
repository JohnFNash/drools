package com.johnfnash.learn.drools.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.johnfnash.learn.drools.model.Cheese;

public class RhsModifyTest {

	public static void main(String[] args) {
		KieServices kieServices = KieServices.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("rhs-modify-rules");
		
		Cheese cheese = new Cheese("stilton", 10, "child");
		kieSession.insert(cheese);
		
		int count = kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("Fire " + count + " rules!");
	}
	
}
