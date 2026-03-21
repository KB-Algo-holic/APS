import java.util.Arrays;

public class PGM_12940_HSH {
    

    public static void main(String[] args) {

        PGM_12940_HSH sol = new PGM_12940_HSH();

        int[] result = sol.solution(3, 12);

        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        return new int[]{gcd, n * m / gcd};
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
