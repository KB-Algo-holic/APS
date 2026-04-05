import java.util.Arrays;

public class PGM_42746_HSH {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = { 6, 10, 2 };
		String answer = solution(input);
		System.out.println(answer);
	}

	public static String solution(int[] numbers) {
		String[] result = new String[numbers.length];
		// input 데이터를 우선 문자열로 바꿔서 배열에 넣어주기 
		for (int i = 0; i < numbers.length; i++) {
			result[i] = String.valueOf(numbers[i]);
		}
		// 문자열로 넣은 배열을 토대로 값을 더해서 내림차순으로 정의한다.
		/***
		 * 예를 들어, 6, 10, 2면 
		 * "6" + "10" => "610"   <-> "10" + "6" => "106"으로 비교하게 되면
		 * "610" 이라는 조합이 더 크기 때문에 a는 "6", b는 "10"으로 잡고 처리가 되는 것입니다.
		 * 
		 */
		Arrays.sort(result, (a, b) -> {
			return (b + a).compareTo(a + b);
		});
		// 큰 것 부터 나오도록 즉, 내림차순으로 정렬하였늗네 처음이 0이다?
		// 모두가 0이다 로 판단 -> "0" 리턴
		if (result[0].equals("0")) {
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		// 배열에 들어갈 때 앞서 조합상 더 큰 값이 나올 수 있도록 조합상의 최상의 값들로 배열에 입력됩니다.
		// 이를 순차적으로 더해서 반환만 하면 최종 결과가 나옵니다. s
		for(String str: result) {
			sb.append(str);
		}
		return sb.toString();
	}
}
