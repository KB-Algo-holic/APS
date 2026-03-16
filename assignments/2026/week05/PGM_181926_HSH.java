public class PGM_181926_HSH {
    

    public static void main(String[] args) {

        PGM_181926_HSH sol = new PGM_181926_HSH();

        String result = sol.solution("abc1abc1abc");

        System.out.println(result);
    }

    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;
        int idx = 0;
        for (char c : code.toCharArray()) {
            if (c == '1')
                mode = mode ^ 1;
            if (mode == 0 && c != '1' && idx % 2 == 0)
                ret.append(c);
            if (mode == 1 && c != '1' && idx % 2 == 1)
                ret.append(c);

            idx++;
        }
        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
}
