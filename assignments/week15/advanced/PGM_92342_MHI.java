import java.util.*;

class Solution {
    static int[] arr = new int[11];
    static int[] answer = { -1 };
    static int minN = -1;
    public int[] solution(int n, int[] info) {

        makeAnswer(info, 0, 0, n);

        return answer;
    }

    private static void makeAnswer(int[] apeach, int idx, int cnt, int n) {
        if(idx == 11) {
            if(cnt == n) {
                int apScore = 0, liScore = 0;
                for(int i=0; i < 11; i++) {
                    if(apeach[i] == 0 && arr[i] == 0) {
                        continue;
                    }
                    if(apeach[i] >= arr[i]) apScore += 10 - i;
                    else liScore += 10 - i;
                }

                if(liScore > apScore) {
                    if(liScore - apScore > minN) {
                        minN = liScore - apScore;
                        answer = arr.clone();
                    }

                    else if(liScore - apScore == minN) {
                        for(int i = 10; i >= 0; i--) {
                            if(answer[i] < arr[i]) {
                                answer = arr.clone();
                                return;
                            }
                            else if(answer[i] > arr[i]) return;
                        }
                    }
                }
            }
            return;
        }

        if(cnt+1 + apeach[idx] <= n) {
            arr[idx] = apeach[idx] + 1;
            makeAnswer(apeach, idx + 1, cnt + 1 + apeach[idx], n);
            arr[idx] = 0;
        }
        if(apeach[idx] != 0) {
            for(int i = 0; i <= apeach[idx]; i++) {
                arr[idx] = i;
                makeAnswer(apeach, idx + 1, cnt + i, n);
                arr[idx] = 0;
            }
        }
        if(apeach[idx] == 0) {
            makeAnswer(apeach, idx+1, cnt, n);
        }

    }
}