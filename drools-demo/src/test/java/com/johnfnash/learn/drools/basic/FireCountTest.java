package com.johnfnash.learn.drools.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class FireCountTest {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ruleFireCount-rules");
        
        for (int i = 0; i < 5; i++) {
            Object obj = new Object();
            kSession.insert(obj);
        }
        
        int count = kSession.fireAllRules();
        System.out.println("Fire " + count + " rules!");
        kSession.dispose();
	}
	
}
