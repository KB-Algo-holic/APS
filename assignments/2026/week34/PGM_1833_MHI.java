// PGM 1833 - 캠핑  
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/1833

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

class Solution {
	
    public int solution(int n, int[][] data) {
    	
    	Set<Integer> xList = new TreeSet<>();
    	Set<Integer> yList = new TreeSet<>();
    	for(int[] next : data) {
    		xList.add(next[0]);
    		yList.add(next[1]);
    	}
    	ArrayList<Integer> xM = new ArrayList<>(xList);
    	ArrayList<Integer> yM = new ArrayList<>(yList);
    		
    	int[][] S = new int[n][n];
    	for(int i=0; i<n; i++) {
    		data[i][0] = xM.indexOf(data[i][0]);
    		data[i][1] = yM.indexOf(data[i][1]);
    		S[data[i][0]][data[i][1]]=1;
    	}
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(i>0) S[i][j]+=S[i-1][j];
    			if(j>0) S[i][j]+=S[i][j-1];
    			if(i>0&&j>0) S[i][j]-=S[i-1][j-1];
    		}
    	}
        int ans = 0;
        
        for(int i=0; i<n-1; i++) {
        	for(int j=i+1; j<n; j++) {
        		
        		if(data[i][0]==data[j][0]||data[i][1]==data[j][1]) continue;
        		
        		int fromX = Math.min(data[i][0], data[j][0]);
        		int toX = Math.max(data[i][0], data[j][0]);
        		int fromY = Math.min(data[i][1], data[j][1]);
        		int toY = Math.max(data[i][1], data[j][1]);
        		
        		if(S[toX-1][toY-1]-S[toX-1][fromY]-S[fromX][toY-1]+S[fromX][fromY]==0) ans++;
        	}
        }
        
        return ans;
    }
}