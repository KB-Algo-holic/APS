package week20;

public class PGM_12924_HSH {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum = 0;
            for(int j = i; j <= n; j++) {
                sum += j;
                if(sum == n) {
                    answer++;
                    break;
                } else if(sum > n) {
                    break;
                }
            }
        }
        return answer;
    }
}
