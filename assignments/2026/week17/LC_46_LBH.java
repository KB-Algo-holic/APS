// Permutations
// 완전탐색
// https://leetcode.com/problems/permutations/

class Solution {
    List<List<Integer>> retList = new ArrayList<>();
    boolean[] visited;
    
    void run(int[] nums, List<Integer> perm) {
        if(perm.size() == nums.length) {
            retList.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm.add(nums[i]);
                run(nums, perm);
                perm.remove(perm.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        List<Integer> perm = new ArrayList<>();
        
        run(nums, perm);

        return retList;
    }
}
