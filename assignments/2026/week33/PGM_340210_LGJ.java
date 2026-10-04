// PGM 340210 수식 복원하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/340210

import java.util.*;

class Solution{
    
    public String[] solution(String[] expressions) {
        
        Arrays.sort(expressions, (a, b) -> Character.compare(a.charAt(a.length()-1), b.charAt(b.length()-1)));
        
        int max = 1;
        int cnt = 0;
        List<String> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        // max 확인 
        for (String ex: expressions) {
            for (char ch: ex.toCharArray()) {
                if (Character.isDigit(ch)) {
                    int n = Character.getNumericValue(ch);
                    if (max < n) max = n;
                }
            } 
        }
        // 후보 idx 등록
        for (int i=max+1; i<=9; i++) set.add(i);
        
        
        
        for (String ex: expressions) {
            String[] divide = ex.split(" ");
            
            String num1 = divide[0];
            String num2 = divide[2];
            String num3 = divide[4]; 
            String op = divide[1];

            // 방정식이 아닌 경우 -> 진법 후보 선별 
            if (!num3.equals("X")) {
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    int idx = iterator.next();
                    int intNum1 = Integer.parseInt(num1, idx);
                    int intNum2 = Integer.parseInt(num2, idx);
                    int intNum3 = Integer.parseInt(num3, idx);
                    
                    if (op.equals("+")) {
                        if (intNum1 + intNum2 != intNum3) {
                            iterator.remove();
                        } 
                    } else {
                        if (intNum1 - intNum2 != intNum3) {
                            iterator.remove();
                        }
                    }
                    
                }
            } else {
                // X 후보
                Set<String> Xs = new HashSet<>();
                
                // 진법 후보를 통해 X 후보 확인하기 
                for (int idx: set) {
                    int intNum1 = Integer.parseInt(num1, idx);
                    int intNum2 = Integer.parseInt(num2, idx);
                    
                    if (op.equals("+")) {
                        Xs.add(Integer.toString(intNum1 + intNum2, idx));
                    } else {
                        Xs.add(Integer.toString(intNum1 - intNum2, idx));
                    }
                }
                
                // 정답 
                String a = num1 + " " + op + " " + num2 + " " + "=" + " ";
                
                if (Xs.size() == 1) {
                    for (String X: Xs) a += X;
                } else {
                    a += "?";
                }
                
                answer.add(a);
            }

            
        }
        
        return answer.toArray(new String[0]);
    }
}
