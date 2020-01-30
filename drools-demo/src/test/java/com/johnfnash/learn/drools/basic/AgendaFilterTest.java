package com.johnfnash.learn.drools.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;

import com.johnfnash.learn.drools.filter.MyAgendaFilter;

public class AgendaFilterTest {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("agendaGroup-rules");
		AgendaFilter filter = new MyAgendaFilter("test-agenda-group");
		kSession.fireAllRules(filter);
		kSession.dispose();
	}
	
}
