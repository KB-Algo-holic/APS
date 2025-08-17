// PGM 340210 - 수식 복원하기
// 완전탐색, 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/340210

import java.util.*;

class Solution {

    List<String[]> correct = new ArrayList<String[]>();
    List<String[]> erase = new ArrayList<String[]>();
    boolean[] bases = new int[10];
    String[] answer;

    int convertBase(String num, int base){
        int sum = 0;
        for(int i = 0; i < num.length; i++) {
            sum += (int)num.charAt(i) * Math.pow(base, num.length - (i + 1));
        }
        return sum;
    }

    void getPossibleBases() {
        for(int j = 2; j <= 9; j++) {
            boolean flag = true;

            for(int i = 0; i < correct.size(); i++) {
                if("+".equals(correct.get(i)[1])){
                    if(convertDecimal(correct.get(i)[0]) + convertDecimal(correct.get(i)[2]) != convertDecimal(correct.get(i)[3])){
                        flag = false;
                        break;
                    }
                } else if("-".equals(correct.get(i)[1])){
                    if(convertDecimal(correct.get(i)[0]) - convertDecimal(correct.get(i)[2]) != convertDecimal(correct.get(i)[3])){
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
                            result = convertDecimal(erase.get(i)[0]) + convertDecimal(erase.get(i)[2]);
                        } else if(result != (convertDecimal(erase.get(i)[0]) + convertDecimal(correct.get(i)[2]))){
                            flag = false;
                            break;
                        }
                    }
                }
            }

            // 진법화 시켜야할듯?
            if(flag) {
                int right = 0;
                for(int j = 2; j <= 9; j++) {
                    if(bases[j]) {
                        right = convertBase("" + result, j);
                        break;
                    }
                }
                answer[i] = {erase.get(i)[0] + " " + erase.get(i)[1] + " " + erase.get(i)[2] + " = " + right};
            } else {
                answer[i] = {erase.get(i)[0] + " " + erase.get(i)[1] + " " + erase.get(i)[2] + " = " + "?"};
            }
        }
    }

    public String[] solution(String[] expressions) {

        // 좌항 우항 나누기
        String[] left;
        String right;

        for(String s : expressions){
            String[] left = s.split(" = ")[0].split(" ");
            String right = s.split(" = ")[1];

            if(!"X".equals(right)){
                correct.add(new String{left[0], left[1], left[2], right});
            } else {
                erase.add(new String{left[0], left[1], left[2], right});
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

    public static void main(String[] args){

    }
}