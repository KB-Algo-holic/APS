//PGM_12935 제일 작은 수 제거하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12935
class Solution {
    public int[] solution(int[] arr) {
        int delidx = 0;
        int min = 99999999;
        if(arr.length <= 1)
            return new int[] {-1};
        for(int i = 0;i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
                delidx = i;
            }
        }
        
        int[] answer = new int[arr.length - 1];
        int n = 0;
        for(int i = 0 ;i < arr.length; i++){
            if(delidx != i)
                answer[n++] = arr[i];
        }
        return answer;
    }
}
