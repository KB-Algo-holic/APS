public class PGM_181932_HSH {

    public static void main(String[] args) {

        PGM_181932_HSH sol = new PGM_181932_HSH();

        int result = sol.solution(0, "wsdawsdassw");

        System.out.println(result);
    }

    public int solution(int n, String control) {
        return n
                + (int) control.chars().filter(c -> c == 'w').count()
                - (int) control.chars().filter(c -> c == 's').count()
                + (int) control.chars().filter(c -> c == 'd').count() * 10
                - (int) control.chars().filter(c -> c == 'a').count() * 10;
    }ß
}
