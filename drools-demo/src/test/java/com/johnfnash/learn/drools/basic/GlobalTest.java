package com.johnfnash.learn.drools.basic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class GlobalTest {

	@SuppressWarnings("unchecked")
	@Test
	public void globalTest() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("global-rules");
		
		List<String> list = new ArrayList<>();
		kSession.setGlobal("myGlobalList", list);
		
		int count = kSession.fireAllRules();
		System.out.println("Fire " +count + " rule(s)!");
		
		list = (List<String>) kSession.getGlobal("myGlobalList");
		for (String str : list) {
			System.out.print(str + " ");
		}
		System.out.println();
		
		kSession.dispose();
	}
	
}
