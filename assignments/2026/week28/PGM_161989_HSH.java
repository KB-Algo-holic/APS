package week28;
public class PGM_161989_HSH {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PGM_161989_HSH sol = new PGM_161989_HSH();
        int n = 5;
        int m = 4;
        int[] section = {1, 3};
        int result = sol.solution(n, m, section);
        System.out.println(result);
    } 

    public int solution(int n, int m, int[] section) {
        int count = 0;

        int start = section[0];
        int end = 0;
        for (int s : section) {

            if (s > end) {
                count++;
                end = s + m - 1;
            }
        }
        return count;
    }
}