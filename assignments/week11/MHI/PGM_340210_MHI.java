import java.util.*;
class Solution {
    public String[] solution(String[] expressions) {

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();

        boolean[] num = new boolean[10];
        for (int i = 0; i < 10; i++) num[i] = true;

        for (String expression : expressions) {
            for (int i = 0; i < expression.length(); i++) {
                int n = expression.charAt(i) - '0';
                if (2 <= n && n <= 9) {
                    for (int j = 0; j <= n; j++) num[j] = false;
                }
            }

            if (expression.contains("X")) {
                ans.add(expression);
            } else {
                list.add(expression);
            }
        }

        for (String expression : list) {
            String exp = expression.split(" = ")[0];
            int answer = Integer.parseInt(expression.split(" = ")[1]);

            int a = Integer.parseInt((exp.contains("+") ? exp.split("\\+")[0] : exp.split("-")[0]).trim());
            int b = Integer.parseInt((exp.contains("+") ? exp.split("\\+")[1] : exp.split("-")[1]).trim());

            for (int i = 2; i < 10; i++) {
                int result = exp.contains("+") ? fromNum(a, i) + fromNum(b, i) : fromNum(a, i) - fromNum(b, i);

                if (answer != toNum(result, i)) num[i] = false;
            }
        }

        String[] answer = new String[ans.size()];

        for (int idx = 0; idx < ans.size(); idx++) {
            String exp = ans.get(idx).split(" = ")[0];

            int a = Integer.parseInt((exp.contains("+") ? exp.split("\\+")[0] : exp.split("-")[0]).trim());
            int b = Integer.parseInt((exp.contains("+") ? exp.split("\\+")[1] : exp.split("-")[1]).trim());

            HashSet<Integer> set = new HashSet<>();

            for (int i = 2; i < 10; i++) {
                if (!num[i]) continue;
                int result = exp.contains("+") ? fromNum(a, i) + fromNum(b, i) : fromNum(a, i) - fromNum(b, i);

                set.add(toNum(result, i));
            }
            if (set.size() == 1) {
                answer[idx] = exp + " = " + set.iterator().next();
            } else {
                answer[idx] = exp + " = ?";
            }
        }

        return answer;
    }

    static int fromNum(int n, int i) {
        String num = n + "";
        int tmp = 0;
        for (int j = 0; j < num.length(); j++) {
            tmp += (num.charAt(j) - '0') * Math.pow(i, num.length() - j - 1);
        }
        return tmp;
    }
    static int toNum(int n, int i) {
        int tmp = 0;
        int j = 0;
        while (n > 0) {
            tmp += (n % i) * Math.pow(10, j);
            n = n / i;
            j ++;
        }
        tmp += n * Math.pow(10, j);
        return tmp;
    }
}