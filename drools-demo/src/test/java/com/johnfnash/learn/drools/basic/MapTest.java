package com.johnfnash.learn.drools.basic;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class MapTest {

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("rhs-map-rules");
        
        Map<String,String> map = new HashMap<>();
        map.put("message", "Hello World");
        map.put("status", "0");
        
        kSession.insert(map); // 插入
        kSession.fireAllRules(); // 执行规则
        kSession.dispose();
	}
	
}
