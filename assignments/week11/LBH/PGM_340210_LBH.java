// PGM 340210 - 수식 복원하기
// 완전탐색, 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/340210

import java.util.*;

class Solution {

    List<String[]> correct = new ArrayList<String[]>();
    List<String[]> erase = new ArrayList<String[]>();
    boolean[] bases = new boolean[10];
    String[] answer;

    int convertDecimal(String num, int base){
        int sum = 0;
        for(int i = 0; i < num.length(); i++) {
            sum += (int)(num.charAt(i) - '0') * Math.pow(base, num.length() - (i + 1));
        }
        return sum;
    }

    void getPossibleBases() {
        for(int j = 2; j <= 9; j++) {
            boolean flag = true;


            for(int i = 0; i < erase.size(); i++) {
                for (int t = 0; t <= 2; t++) {
                    if (t != 1) {
                        if (erase.get(i)[t].charAt(0) - '0' >= j) {
                            if (erase.get(i)[t].length() > 1) {
                                if (erase.get(i)[t].charAt(1) - '0' >= j) {
                                    flag = false;
                                    break;
                                }
                            }
                            flag = false;
                            break;
                        }
                    }
                }
            }

            for(int i = 0; i < correct.size(); i++) {

                for(int t = 0; t <= 3; t++) {
                    if(t != 1) {
                        if (correct.get(i)[t].charAt(0) - '0' >= j) {
                            if (correct.get(i)[t].length() > 1) {
                                if (correct.get(i)[t].charAt(1) - '0' >= j) {
                                    flag = false;
                                    break;
                                }
                            }
                            flag = false;
                            break;
                        }
                    }
                }

                if("+".equals(correct.get(i)[1])){
                    if(convertDecimal(correct.get(i)[0], j) + convertDecimal(correct.get(i)[2], j) != convertDecimal(correct.get(i)[3], j)){
                        flag = false;
                        break;
                    }
                } else if("-".equals(correct.get(i)[1])){
                    if(convertDecimal(correct.get(i)[0], j) - convertDecimal(correct.get(i)[2], j) != convertDecimal(correct.get(i)[3], j)){
                        flag = false;
                        break;
                    }
                }
            }

            if(flag) {
                bases[j] = true;
            }
        }
    }

    void calcPossibleBases() {

        for(int i = 0; i < erase.size(); i++) {
            int result = 0;
            boolean first = true;
            boolean flag = true;

            for(int j = 2; j <= 9; j++) {
                if(bases[j]) {
                    if("+".equals(erase.get(i)[1])){
                        if(first) {
                            result = convertDecimal(erase.get(i)[0], j) + convertDecimal(erase.get(i)[2], j);
                            result = Integer.parseInt(Integer.toString(result, j));
                            first = false;
                        } else if(result != Integer.parseInt(Integer.toString(convertDecimal(erase.get(i)[0], j) + convertDecimal(erase.get(i)[2], j), j))){
                            flag = false;
                            break;
                        }
                    } else {
                        if(first) {
                            result = convertDecimal(erase.get(i)[0], j) - convertDecimal(erase.get(i)[2], j);
                            result = Integer.parseInt(Integer.toString(result, j));
                            first = false;
                        } else if(result != Integer.parseInt(Integer.toString(convertDecimal(erase.get(i)[0], j) - convertDecimal(erase.get(i)[2], j), j))){
                            flag = false;
                            break;
                        }
                    }
                }
            }

            // 진법화 시켜야할듯?
            if(flag) {
                answer[i] = erase.get(i)[0] + " " + erase.get(i)[1] + " " + erase.get(i)[2] + " = " + result;
            } else {
                answer[i] = erase.get(i)[0] + " " + erase.get(i)[1] + " " + erase.get(i)[2] + " = " + "?";
            }
        }
    }

    public String[] solution(String[] expressions) {

        // 좌항 우항 나누기
        String[] left;
        String right;

        for(String s : expressions){
            left = s.split(" = ")[0].split(" ");
            right = s.split(" = ")[1];

            if(!"X".equals(right)){
                correct.add(new String[]{left[0], left[1], left[2], right});
            } else {
                erase.add(new String[]{left[0], left[1], left[2], right});
            }
        }

        // 진법 변환 함수
        // 가능한 진법 뽑아내기
        getPossibleBases();

        // 가능한 진법에 한해 X 계산하기
        answer = new String[erase.size()];

        // X가 여러개면 ?, 같은 값이면 채워넣기
        calcPossibleBases();

        return answer;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        System.out.println(S.solution(new String[]{"1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"}));
    }
}