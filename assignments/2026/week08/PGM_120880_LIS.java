// PGM 120880 - 특이항 정렬
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/120880
class Solution {
    public int[] solution(int[] numlist, int n) {
//        int[] answer = {};
//        return answer;
//        int[] answer = new int[n];      

        int size = numlist.length;
        int tempI;
        int tempJ;
        int temp;       

        for(int i = 0; i < size; i++) {
            
            tempI = Math.abs(numlist[i] - n);          

            for(int j = i; j < size; j++) {

                tempJ = Math.abs(numlist[j] - n);
                System.out.println("tempI : " + tempI + " tempJ : " + tempJ + " / numlist[i] : " + numlist[i] + " numlist[j] : " + numlist[j]);               
                // 뒤에정수가 거리가 가까우면 앞으로 이동
                if(tempJ < tempI) {
                    temp       = numlist[j];
                    numlist[j] = numlist[i];
                    numlist[i] = temp;
                    tempI = tempJ;
                    //print(numlist);
                }
                // 거리가 같고, 숫자가 더 크면 앞으로이동
                else if(tempJ == tempI && numlist[j] > numlist[i]) {
                    temp       = numlist[j];
                    numlist[j] = numlist[i];
                    numlist[i] = temp;
                    tempI      = tempJ;

                    //print(numlist);
                }
            }
        }
        return numlist;
    }
}
