class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        makeAns(numbers, target, 0, 0);
        return answer;
    }

    public void makeAns(int[] number, int target, int i, int sum) {
        if (i == number.length) {
            if (sum == target) answer ++;
            return;
        }
        makeAns(number, target, i + 1, sum + number[i]);
        makeAns(number, target, i + 1, sum - number[i]);
    }
}