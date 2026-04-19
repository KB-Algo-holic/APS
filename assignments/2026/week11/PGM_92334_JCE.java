import java.util.*;

class Solution {

  public static int[] solution(String[] id_list, String[] report, int k) {
      int[] answer = new int[id_list.length];
      HashMap<String, Set<String>> hm = new HashMap<>();
  
      for (String r : report) {
          StringTokenizer st = new StringTokenizer(r, " ");
          String a = st.nextToken(); // 신고 한 사람
          String b = st.nextToken(); // 신고 당한 사람
  
          hm.computeIfAbsent(b, s -> new HashSet<>()).add(a);
      }
  
      Map<String, Integer> idMap = new LinkedHashMap<>();
      for (String id : id_list) {
          idMap.put(id, 0);
      }
  
      for (String key : hm.keySet()) {
          if (hm.get(key).size() >= k) {
              Set<String> toMail = hm.get(key);
              for (String name : toMail) {
                  idMap.put(name, idMap.get(name) + 1);
              }
          }
      }
  
      answer = idMap.values().stream()
              .mapToInt(Integer::intValue)
              .toArray();
  
      return answer;
  }
}
