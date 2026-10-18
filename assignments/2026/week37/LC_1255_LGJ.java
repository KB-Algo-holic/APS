// LC 1255 - maximum-score-words-formed-by-letters
// 완전탐색 
// https://leetcode.com/problems/maximum-score-words-formed-by-letters/


class Solution {
    int n;
    int answer = 0;
    int[] wordScore;
    int[][] wordCnt;
    int[] letterCnt = new int[26]; //사용 가능한 letter들의 개수

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        n = words.length;
        wordScore = new int[n];
        wordCnt = new int[n][26];

        for (int i=0; i<n; i++) {
            String word = words[i];
            int total = 0;
            
            // 'a' == 97
            for (char c: word.toCharArray()) {
                int aschi = (int) c;
                total += score[aschi-97];
                wordCnt[i][aschi-97] += 1;
            }
            wordScore[i] = total;
            
        }

        for (char c: letters) {
            letterCnt[(int) c - 97] +=1;
        }

        dfs(0, 0, words);

        return answer;   
    }

    private void dfs(int depth, int score, String[] words) {

        if (depth == n) {
            answer = Math.max(score, answer);
            return;
        }
        // 선택 x
        dfs(depth+1, score, words);

        // 선택 o
        int[] cnts = wordCnt[depth];
        for (int i=0; i<26; i++) {
            if (letterCnt[i] < cnts[i]) return;
        }

        for (int i=0; i<26; i++) {
            letterCnt[i] -= cnts[i];
        }
        dfs(depth+1, score+wordScore[depth], words);
        for (int i=0; i<26; i++) {
            letterCnt[i] += cnts[i];
        }
        
    }

}
