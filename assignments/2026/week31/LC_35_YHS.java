// LC - 35 search-insert-position
// BFS
// https://leetcode.com/problems/search-insert-position/description/
public class LC_35_YHS {
    public int searchInsert(int[] nums, int target) {
        int answer = 0;

        boolean flag = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= target){
                answer = i;
                flag = true;
                break;
            }
        }

        if(!flag){
            answer = nums.length;
        }

        return answer;
    }
}
