package com.johnfnash.learn.drools.basic;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.johnfnash.learn.drools.model.Person;

public class FactHandlerTest {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("factHandle-rules");

        Person p = new Person();
        p.setAge(78);
        
        FactHandle handle = kSession.insert(p);
        System.out.println(handle.toExternalForm());
        
        int count = kSession.fireAllRules();
        System.out.println("Fire " + count + " rules!");
        
        p.setAge(90);
        kSession.update(handle, p);
        
        count = kSession.fireAllRules();
        System.out.println("Fire " + count + " rules!");
        
        kSession.dispose();
	}
	
}
