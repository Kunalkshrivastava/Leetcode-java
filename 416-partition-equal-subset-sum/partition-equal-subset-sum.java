class Solution {

    private int helper(int ind, int target, int[] nums, int[][] dp) {
        if(ind >= nums.length)
            return (target == 0) ? 1 : 0;

        if(dp[ind][target] != -1)
            return dp[ind][target];

        if(helper(ind+1, target, nums, dp) == 1)
            return dp[ind][target] = 1;

        if(nums[ind] <= target)
            return dp[ind][target] = helper(ind+1, target - nums[ind], nums, dp);

        return dp[ind][target] = 0;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length ; i++)
            sum += nums[i];

        if(sum % 2 == 1) return false;

        int dp[][] = new int[nums.length][(sum/2) + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return helper(0, sum/2 , nums, dp) == 1 ? true : false;
    }
}   
