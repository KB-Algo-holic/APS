# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 12945 - 피보나치수
# 유형: -
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12945

import java.util.*;

public int solution(int n) {
        //피보나치 수열은 첫째 및 둘째항이 1이고, 그 뒤의 모든 항은 바로 앞 두항의 합으로 이루어진 수열
        //1,1,2,3,5,8,13,21...
        int answer = 0;
        
        int[] tempList = new int[n];
        tempList[0] = 1;
        tempList[1] = 1;
        
        for(int idx = 2; idx < n; idx++){
            tempList[idx] = (tempList[idx-2] + tempList[idx-1]) % 1234567;
        }
        answer = tempList[tempList.length-1];
        return answer;
    }
}