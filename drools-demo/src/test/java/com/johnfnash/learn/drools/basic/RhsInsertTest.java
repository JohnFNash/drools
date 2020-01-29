package com.johnfnash.learn.drools.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RhsInsertTest {

	public static void main(String[] args) {
		KieServices kieServices = KieServices.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("rhs-insert-rules");
		int count = kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("Fire " + count + " rules!");
	}
	
}
