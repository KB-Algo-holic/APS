class Solution {
    public String solution(int[] numbers, String hand) {
        int map[][] = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
		String answer = "";
		
		int left_x = 3;
		int left_y = 0;
		int right_x = 3;
		int right_y = 2;
		
		for(int i=0;i<numbers.length;i++)
        {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7)
            {
                left_x = map[numbers[i]][0];
                left_y = map[numbers[i]][1];
                answer += "L";
            }
			else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9)
            {
				right_x = map[numbers[i]][0];
				right_y = map[numbers[i]][1];
				answer += "R";
            }
			else {
				int left_dis = Math.abs(left_x - map[numbers[i]][0]) + Math.abs(left_y - map[numbers[i]][1]);
				int right_dis = Math.abs(right_x - map[numbers[i]][0]) + Math.abs(right_y - map[numbers[i]][1]);
				if(left_dis > right_dis)
				{
					right_x = map[numbers[i]][0];
					right_y = map[numbers[i]][1];
					answer += "R";
				}
				else if(left_dis < right_dis)
				{
					left_x = map[numbers[i]][0];
	                left_y = map[numbers[i]][1];
	                answer += "L";
				}
				else
				{
					if(hand.equals("right"))
					{
						right_x = map[numbers[i]][0];
						right_y = map[numbers[i]][1];
						answer += "R";
					}
					else
					{
						left_x = map[numbers[i]][0];
		                left_y = map[numbers[i]][1];
		                answer += "L";
					}
				}
			}
        }
		return answer;
    }
}
