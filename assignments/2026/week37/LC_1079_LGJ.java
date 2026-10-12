// LC 1079 - Letter Tile Possibilities
// 완전탐색
// https://leetcode.com/problems/letter-tile-possibilities/


class Solution {

    Set<String> results = new HashSet<>();
    int n;
    boolean[] visited;
    int answer = 0;

    public int numTilePossibilities(String tiles) {
        n = tiles.length();
        visited = new boolean[n];
        for (int i=1; i<=n; i++) {
            dfs(0, i, new StringBuilder(""), tiles);
        }
        //System.out.println(results);
        return results.size();
    }

    private void dfs(int depth, int r, StringBuilder cur, String tiles) {

        if (depth == r) {
            //System.out.println(cur.toString());
            results.add(cur.toString());

            return ;
        }

        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            cur.append(tiles.charAt(i));
            visited[i] = true;
            dfs(depth+1, r, cur, tiles);
            cur.deleteCharAt(depth);
            visited[i] = false;
        }

    }
}