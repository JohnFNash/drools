package com.johnfnash.learn.drools.demo;

import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ScoreGradeTest {

	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kc = ks.getKieClasspathContainer();
			KieSession kSession = kc.newKieSession("score-rules");
			
			Scanner in = new Scanner(System.in);
            System.out.println("请输入需要评级的分数：（输入0退出循环）");
            int data = in.nextInt();
            while(data != 0) {
            	Score score = new Score(data);
            	kSession.insert(score);
            	kSession.fireAllRules();
                System.out.println("请输入需要评级的分数：（输入0退出循环）");
                data = in.nextInt();
            }
            in.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static class Score {
		public int score;
		
		Score(int score) {
			this.score = score;
		}
		
		public int getScore() {
			return score;
		}
	}
	
}
