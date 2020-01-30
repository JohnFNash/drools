package com.johnfnash.learn.drools.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class AgendaGroupTest {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("agendaGroup-rules");
		kSession.getAgenda().getAgendaGroup("abc").setFocus();
		kSession.fireAllRules();
		kSession.dispose();
	}
	
}
