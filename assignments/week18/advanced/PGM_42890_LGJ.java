import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int rowCnt = relation.length;
        HashMap<Integer, HashSet<String>> columns = new HashMap<>();
        for (String[] row: relation) {
            for (int i=0; i<row.length; i++) {
                HashSet<String> temp = columns.getOrDefault(i, new HashSet<>());
                temp.add(row[i]);
                columns.put(i, temp);
            }
        }
        System.out.println(columns);
        for (int key: columns.keySet()) {
            if (columns.get(key).size() == rowCnt) answer ++;
        }


        return answer;
    }
}