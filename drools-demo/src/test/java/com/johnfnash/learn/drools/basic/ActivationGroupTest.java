package com.johnfnash.learn.drools.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ActivationGroupTest {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("activationGroup-rules");
		kSession.fireAllRules();
		kSession.dispose();
	}
	
}
