// PGM 178870 - 연속된 부분 수열의 합
// 투포인터
// https://school.programmers.co.kr/learn/courses/30/lessons/178870

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        // two pointer
        int diff    = (int)1e9;
        int left    = 0;
        int right   = 0;
        int sum     = sequence[0];
        int[] result = new int[2];
        while(left < sequence.length && right < sequence.length){
            if(sum==k){
                //정답 후보이다.
                // System.out.println("걸렸다!");
                if(right-left < diff){
                    diff = right - left;
                    result[0] = left;
                    result[1] = right;
                }
                sum -= sequence[left];
                left++;
            }
            
            else if(sum<k){
                //sum이 더 작다? right를 늘린다.
                right+=1;
                if(right == sequence.length) break;
                sum += sequence[right];
            }
            
            else{
                // sum이 더 크다? left를 늘린다.
                sum -= sequence[left];
                left+=1;
            }
        }
        
        
        return result;
    }
}