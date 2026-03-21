public class PGM_60058_HSH {
    public static void main(String[] args) {

        PGM_60058_HSH sol = new PGM_60058_HSH();

        String result = sol.solution("(()())()");

        System.out.println(result);
    }

    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }

        int balance = 0;
        int index = 0;

        for (char c : p.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            index++;
            if (balance == 0) {
                break;
            }
        }

        String u = p.substring(0, index);
        String v = p.substring(index);

        if (isValid(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            for (int i = 1; i < u.length() - 1; i++) {
                sb.append(u.charAt(i) == '(' ? ')' : '(');
            }
            return sb.toString();
        }
    }

    private boolean isValid(String u) {
        int balance = 0;
        for (char c : u.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
