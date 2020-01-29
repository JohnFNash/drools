package com.johnfnash.learn.drools.basic;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.johnfnash.learn.drools.model.Company;

public class ListTest {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("rhs-list-rules");
		
		Company company = new Company();
		List<String> targetList = new ArrayList<>();
		targetList.add("教育");
		targetList.add("P2P");
		company.setScopes(targetList);

		List<String> blackList = new ArrayList<>();
		blackList.add("房地产");
		blackList.add("游戏");
		blackList.add("P2P");

		kSession.insert(company);
		kSession.insert(blackList);
		kSession.fireAllRules();
		kSession.dispose();
	}
	
}
