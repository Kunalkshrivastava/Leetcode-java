
class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i = 0; i<n ; i++)
            sum += nums[i];

        if(sum % 2 == 1) return false;
        int target = sum/2;

        boolean dp[][] = new boolean[n+1][target + 1];
        for (boolean row[] : dp)
            Arrays.fill(row, false);

        dp[0][0] = true;
        for(int i = 1; i<=n ; i++)
            dp[i][0] = true;

        for(int i = 1; i<=n ; i++) {
            for(int j = 1; j<= target ; j++) {
                //inc
                if(nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j-nums[i-1]];
                //exc
                dp[i][j] = dp[i][j] || dp[i-1][j];
            }
        }

        return dp[n][target];
    }
}