package com.johnfnash.learn.drools.basic;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import com.johnfnash.learn.drools.model.Person;

public class QueryTest {

	@Test
	public void queryTest() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("query-rules");
		
		Person p1 = new Person();
		p1.setAge(29);
		Person p2 = new Person();
		p2.setAge(40);
		
		kSession.insert(p1);
		kSession.insert(p2);
		
		int count = kSession.fireAllRules();
		System.out.println("Fire " +count + " rule(s)!");
		
		QueryResults results = kSession.getQueryResults("query-1");
		System.out.println("results size is " + results.size());
		Person person;
		for (QueryResultsRow row : results) {
			person = (Person) row.get("$person");
			System.out.println("Person from WM, age：" + person.getAge());
		}
		
		kSession.dispose();
	}
	
	@Test
    public void queryWithParamTest2() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("query-rules");

        Person p1 = new Person();
        p1.setAge(29);
        p1.setName("Ross");
        Person p2 = new Person();
        p2.setAge(40);
        p2.setName("Tom");

        kSession.insert(p1);
        kSession.insert(p2);
        int count = kSession.fireAllRules();
        System.out.println("Fire " +count + " rule(s)!");

        QueryResults results = kSession.getQueryResults("query-2","Tom");
        System.out.println("results size is " + results.size());
        for(QueryResultsRow row : results){
            Person person = (Person) row.get("$person");
            System.out.println("Person from WM, age : " + person.getAge() + "; name :" + person.getName());
        }

        kSession.dispose();
    }
	
}
