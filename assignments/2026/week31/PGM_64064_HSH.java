package week31;

import java.util.HashSet;
import java.util.Set;

public class PGM_64064_HSH {
    static String[] userIds;
    static String[] bannedIds;
    static boolean[] visited;
    static Set<Integer> result = new HashSet<>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PGM_64064_HSH sol = new PGM_64064_HSH();
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = { "fr*d*", "*rodo", "******", "******"};

        System.out.println(sol.solution(user_id, banned_id));
    }

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;

        visited = new boolean[user_id.length];
        dfs(0,0);
        return result.size();
    }

    public void dfs(int depth, int start) {
        if(depth == bannedIds.length) {
            result.add(start);
            return;
        }
        for(int i=0;i<userIds.length;i++ ){
            if(!visited[i] && isMatch(userIds[i],  bannedIds[depth])) {
                visited[i] = true;
                dfs(depth + 1, start | (1 << i));
                visited[i] = false;
            }
        }
    }

    private boolean isMatch(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) return false;
        for(int i=0;i<userId.length();i++) {
            if(bannedId.charAt(i) == '*') continue;
            if(userId.charAt(i) != bannedId.charAt(i)) return false;
        }
        return true;
    }
}