# 아래 주석 양식을 필히 작성하여 주세요.
# PGM 42842 - 카펫
# 유형: 완전탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842
# 해설: 노란색(yellow) 블록의 약수를 구한 뒤, 해당 약수를 이용해 가능한 세로(c)와 가로(r)를 계산해 봅니다. 이때 가로가 세로보다 크거나 같도록 배치하며, 갈색(brown) 블록의 개수가 조건에 부합하는지 확인합니다.
## 세부 로직:
	1. yellow의 약수 c를 1부터 √(yellow)까지 순회하며 찾습니다.
	2. yellow를 c로 나눈 몫 r을 구해 세로(c), 가로(r) 쌍을 구성합니다.
	3. 해당 쌍에서 갈색 블록의 수는 r*2 + c*2 + 4로 계산됩니다.
	4. 이 값이 brown과 일치한다면, 정답은 [r+2, c+2]입니다. (테두리를 감싸는 블록이므로 가로, 세로 각각 +2가 필요함)

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int c = 1; c <= Math.sqrt(yellow); c++) {
            if(yellow % c == 0) {
                int r = yellow / c;
                
                if(r *2 + c * 2 + 4 == brown) {
                    answer = new int[] {r + 2, c + 2};
                    break;
                }
            }
        }
        
        return answer;
    }
}