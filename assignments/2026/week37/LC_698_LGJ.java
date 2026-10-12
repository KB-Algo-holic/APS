// LC - 698 Partition to K Equal Sum Subsets
// 완전탐색
// https://chatgpt.com/c/6aae162b-7fa8-83ee-bb7d-cd311b0f05e2


class Solution {
    boolean answer = false;
    int[] subsets;
    int target = 0;
    int n;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // n개의 숫자들을 k 개의 부분집합으로 나누는 경우의 수
        n = nums.length;
        subsets = new int[k];
        int total = 0;
        for (int i=0; i<n; i++) total += nums[i];
        if (total % k == 0) {
            target = total/k;
            dfs(0, k, nums);
        }
        return answer;
    }
    private void dfs(int depth, int k, int[] nums) {

        if (depth == n) {
            //System.out.println(Arrays.toString(subsets));
            answer = true;
            return ;
        }

        Set<Integer> set = new HashSet<>();

        for (int i=0; i<k; i++) {
            if (!set.add(subsets[i])) continue;
            if (subsets[i] + nums[depth] > target) continue;

            subsets[i] += nums[depth];

            // plunning
            dfs(depth+1, k, nums);

            // backtracking
            subsets[i] -= nums[depth];
        }

    }
}
