package com.johnfnash.learn.drools.basic;

import java.util.HashSet;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.johnfnash.learn.drools.model.Corporation;
import com.johnfnash.learn.drools.model.Scope;

public class ContainsDemo {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.newKieClasspathContainer();
		KieSession kSession = kc.newKieSession("listContains-rules");
		
		Corporation corporation = new Corporation();
		Set<Scope> scopes = new HashSet<>();
		scopes.add(new Scope("P2P"));
		scopes.add(new Scope("金融"));
        scopes.add(new Scope("区块链"));
        corporation.setScopes(scopes);

        Scope scope = new Scope("区块链");
        
		kSession.insert(corporation);
		kSession.insert(scope);
		
		kSession.fireAllRules();
		kSession.dispose();
	}
	
}
