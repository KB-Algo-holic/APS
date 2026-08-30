import java.util.*;

public class Solution {

    private static Map<String, ArrayList<String>> map = new HashMap<>();

    public String[] solution(String[][] tickets) {
        map.clear();

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new ArrayList<>()).add(ticket[1]);
        }

        for (ArrayList<String> list : map.values()) {
            Collections.sort(list);
        }

        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", path, tickets.length);

        return path.toArray(new String[0]);
    }

    private boolean dfs(String airport, List<String> path, int totalTickets) {
        if (path.size() == totalTickets + 1) {
            return true;
        }

        List<String> nextAirports = map.get(airport);
        if (nextAirports == null) return false;

        for (String next : new ArrayList<>(nextAirports)) {
            nextAirports.remove(next);
            path.add(next);

            if (dfs(next, path, totalTickets)) {
                return true;
            }

            nextAirports.add(next);
            path.remove(path.size() - 1);
        }

        return false;
    }
}
