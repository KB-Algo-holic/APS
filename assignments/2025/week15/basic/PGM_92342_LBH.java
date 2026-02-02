// PGM 92342 - 양궁대회
// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/92342

class Solution {

    double max = 0.5f;
    int[] maxArray;
    int[] ryan;
    void DFS(int n, int[] info, int times, int idx){
        if(times == n){
            int apeachSum = 0;
            int ryanSum = 0;
            for(int i = 0; i <= 10; i++){
                if(ryan[i] == 0 && info[i] == 0){
                    continue;
                }

                if(ryan[i] <= info[i]){
                    apeachSum += (10 - i);
                } else {
                    ryanSum += (10 - i);
                }
            }

            if(max < ryanSum - apeachSum){
                max = ryanSum - apeachSum;
                maxArray = ryan.clone();

            } else if(max == ryanSum - apeachSum){
                for(int i = 10; i >= 0; i--){
                    if(maxArray[i] == 0 && ryan[i] == 0){
                        continue;
                    }

                    if(maxArray[i] < ryan[i]){
                        maxArray = ryan.clone();
                        break;
                    } else {
                        break;
                    }
                }
            }

            return;
        }


        for(int i = idx; i <= 10; i++){
            ryan[i]++;
            DFS(n, info, times + 1, i);
            ryan[i]--;
        }
    }

    public int[] solution(int n, int[] info) {
        maxArray = new int[11];
        ryan = new int[11];

        DFS(n, info, 0, 0);

        if(max >= 1){
            return maxArray;
        } else {
            return new int[]{-1};
        }
    }
}