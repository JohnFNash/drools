package com.johnfnash.learn.drools.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.johnfnash.learn.drools.model.Applicant;

public class HelloWorld {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("all-rules");
		
		Applicant a = new Applicant();
		a.name = "Xiao,ming";
		a.age = 15;
		a.valid = true;
		kSession.insert(a);
		
		int fireCnt = kSession.fireAllRules();
		kSession.dispose();
		
		System.out.println(fireCnt + " rule(s) has been fired.");
		System.out.println(a.valid);
	}
	
}
