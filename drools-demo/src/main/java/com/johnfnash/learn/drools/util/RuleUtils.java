package com.johnfnash.learn.drools.util;

import java.util.List;

public class RuleUtils {

	/**
	 * 判断targetList是否有元素出现在blackList中
	 * @param targetList
	 * @param blackList
	 * @return
	 */
	public static Boolean toCompareList(List<String> targetList, List<String> blackList) {
		Boolean flag = false;
		for(Object obj : targetList){
	        if(blackList.contains(obj)){
	            flag  = true;
	            break;
	        }
	    }
	    return flag;
	}
	
}
