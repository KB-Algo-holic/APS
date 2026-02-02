import java.util.*;

class Solution {
    static ArrayList<String> list;
    static String[] item = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static boolean[] used;

    public int solution(int n, String[] data) {
        list = new ArrayList<>();
        used = new boolean[8];

        make("");

        int answer = 0;
        for (String word : list) {
            boolean isPossible = true;
            for (String condition : data) {
                int a = word.indexOf(condition.charAt(0));
                int b = word.indexOf(condition.charAt(2));
                int dist = Math.abs(a - b) - 1;
                char op = condition.charAt(3);
                int num = condition.charAt(4) - '0';

                if (op == '=') {
                    if (!(dist == num)) { isPossible = false; break; }
                } else if (op == '<') {
                    if (!(dist < num)) { isPossible = false; break; }
                } else if (op == '>') {
                    if (!(dist > num)) { isPossible = false; break; }
                }
            }
            if (isPossible) answer++;
        }

        return answer;
    }

    static void make(String word) {
        if (word.length() == 8) {
            list.add(word);
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!used[i]) {
                used[i] = true;
                make(word + item[i]);
                used[i] = false;
            }
        }
    }
}