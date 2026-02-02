// PGM 42860 - 조이스틱
// 유형: 시뮬레이션
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42860
class Solution {
    public int solution(String name) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < name.length(); i++){
            int num = 0;

            // A~M 1씩 증가
            // N~Z 1씩 감소
            for(char c = 'A'; c <= 'Z'; c++){
                if(name.charAt(i) == c){
                    sum += num; // 목표 도달하면 누적
                    break;
                }
                if(c <= 'M') num++; // 정방향 증가
                else num--;          // 역방향 감소
            }
        }

        // A가 아닌 위치만 따로 저장 (
        for(int i = 0; i < name.length(); i++){
            if(name.charAt(i) != 'A'){
                list.add(i);
            }
        }

        int min = Integer.MAX_VALUE;

        // 이동할 필요가 없는 경우
        if(list.size() == 0) {
            min = 0;
        }
        // A가 아닌 문자가 한 곳만 있는 경우
        else if(list.size() == 1){
            int idx = list.get(0);
            int backwards = name.length() - idx; // 뒤로 이동
            min = Math.min(idx, backwards);
        }

        else{
            // 오른쪽 → 왼쪽
            int num1 = list.get(0);
            int num2 = 0;

            for(int i = 1; i < list.size(); i++){
                num2 = list.get(i);

                // 오른쪽 갔다가 뒤로 돌아오는 방식 계산
                min = Math.min(num1 * 2 + (name.length() - num2), min);

                num1 = num2;
            }

            // 전체 오른쪽 이동만 하는 경우
            min = Math.min(num2, min);

            // 왼쪽 → 오른쪽 형태 탐색
            for(int i = list.size() - 2; i >= 0; i--){
                num1 = list.get(i);

                // 뒤에서 시작하여 돌아오는 케이스
                min = Math.min((name.length() - (num2 + 1)) * 2 + 2 + num1, min);
                num2 = num1;
            }
        }

        answer = sum + min;

        return answer;
    }
}
