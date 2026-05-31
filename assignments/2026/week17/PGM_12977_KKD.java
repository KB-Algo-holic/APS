// PGM_12977 소수 만들기
// 구현
// school.programmers.co.kr/learn/courses/30/lessons/12977
class Solution {
    
    static private boolean[] visit;
    static private int result = 0;
    public int solution(int[] nums) {
        int answer = -1;
        visit = new boolean[nums.length];
        
        comb(nums,0,nums.length,3);

        return result;
    }
    
    public boolean isPrime(int sum)
    {
        for(int i=2;i<=Math.sqrt(sum);i++)
        {
            if(sum % i == 0)
                return false;
        }
        return true;
    }
    
    public void comb(int[] nums,int start,int n,int r)
    {
        if(r==0)
        {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if(visit[i]) {
                    //System.out.print(nums[i] + " ");
                    sum = sum+nums[i];
                }
            }
            //System.out.println();
            if(isPrime(sum))
            {
                //System.out.println("sum "+sum);
                result++;
            }
            return;
        }
        
        for(int i=start;i<n;i++)
        {
            visit[i] = true;
            comb(nums,i+1,n,r-1);
            visit[i] = false;
            
        }
    }
}
