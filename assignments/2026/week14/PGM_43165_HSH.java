package week14;

public class PGM_43165_HSH {

    private static int answer = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = { 1, 1, 1, 1, 1 };

        int target = 3;
        solution(nums, target, 0, 0);
        System.out.println(answer);
    }

    public static void solution(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length) {
            if (sum == target) {
                answer += 1;
            }
            return;
        }

        solution(numbers, target, sum + numbers[index], index + 1);
        solution(numbers, target, sum - numbers[index], index + 1);
    }
}
