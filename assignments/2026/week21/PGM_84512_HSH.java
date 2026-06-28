package week21;

public class PGM_84512_HSH {

    static String[] arr = { "A", "E", "I", "O", "U" };
    static int count;

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }

    public static int solution(String word) {
        count = 0;
        dfs(word, "", 0);
        return count;
    }

    /*
     * 여기서 핵심은 찾는 단어와 현재 단어에 값 더해가면서 비교하고 depth 값으로 탐색 이어서하기
     * 단, 값을 찾았을 때에는 리턴해서 종료ㅛ
     */
    public static boolean dfs(String target, String current, int depth) {
        // 빈 값이 아닌 경우 현재 값과 찾는 값이 같으면 끝
        if (!current.isEmpty()) {
            count += 1;
            if (current.equals(target)) {
                return true;
            }
        }
        // 최대 5번까지 돌도록! (모음사전))
        if(depth == 5){
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            boolean isFoundTarget = dfs(target, current + arr[i], depth + 1);

            if(isFoundTarget) {
                return true;
            }
        }

        return false;
    }
}