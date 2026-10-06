// PGM 42893 - 매칭 점수
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/42893

import java.util.ArrayList;

class Solution {
	
	
    public int solution(String word, String[] pages) {
    	
    	String[] address = new String[pages.length];
    	double[] basic = new double[pages.length];
    	int[] linkNum = new int[pages.length];
    	ArrayList<String>[] link = new ArrayList[pages.length];
    	for(int i=0; i<pages.length; i++) {
    		link[i]=new ArrayList<String>();
    	}
    	
    	word = word.toLowerCase();
    	
    	for(int i=0; i<pages.length; i++) {
    		String now = pages[i].toLowerCase();
    		int count=0;
    		int index=0;

    		while((index=now.indexOf(word,index))>=0) {
    			if(('z'<now.charAt(index-1)||now.charAt(index-1)<'a')&&
    					('z'<now.charAt(index+word.length())||now.charAt(index+word.length())<'a')) count++;
    			index+=word.length();
    		}
    		basic[i]=count;
    		int from=now.indexOf("<meta property=")+33;
    		int to = now.indexOf('"',from);
    		address[i] = now.substring(from,to);
    		index=0;
    		while((index=now.indexOf("<a href=",index))>=0) {
    			from = index+9;
    			to = now.indexOf('"',from);
    			link[i].add(now.substring(from,to));
    			index=to;
    		}
    	}
    	
    	double[] linkScore = new double[pages.length];
    	for(int i=0; i<pages.length; i++) {
    		for(String next : link[i]) {
    			for(int j=0; j<pages.length; j++) {
    				if(next.equals(address[j])) {
    					linkScore[j]+=(basic[i]/link[i].size());
    				}
    			}
    		}
    	}
    	float[] ans = new float[pages.length];
    	float max = 0;
    	for(int i=0; i<ans.length; i++) {
    		ans[i]=(float) (basic[i]+linkScore[i]);
    		max=Math.max(max, ans[i]);
    	}
    	int answer = 0;
    	for(int i=0; i<ans.length; i++) {
    		if(max==ans[i]) {
    			answer = i;
    			break;
    		}
    	}
        return answer;
    }
}