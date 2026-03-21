package week06;

public class PGM_60057_HSH {
    public static void main(String[] args) {
        PGM_60057_HSH sol = new PGM_60057_HSH();

        int result = sol.solution("abcabcabcdabcd");
        System.out.println(result);
    }

    public int solution(String s) {
        int answer = s.length();
        if (s.length() == 1)
            return 1;

        for (int i = 1; i <= s.length() / 2; i++) {
            String tmp = ""; // 중복되는 문자열 우선 저장해 둘 곳
            for (int j = 0; j < s.length(); j += i) {
                String preStr = s.substring(j, (j + i > s.length() ? s.length() : j + i));
                int count = 1;

                if ((j + i) <= s.length()) {
                    while (preStr.equals(s.substring((j + i), (j + i + i > s.length() ? s.length() : j + i + i)))) {
                        count++;
                        j = j + i;
                        if (j + i + i > s.length())
                            break;
                    }
                }
                tmp += (count == 1) ? preStr : count + preStr;
            }
            if (tmp.length() < answer)
                answer = tmp.length();
        }
        return answer;
    }
}
