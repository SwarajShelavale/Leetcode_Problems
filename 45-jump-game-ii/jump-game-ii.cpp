class Solution {
public:
    int jump(vector<int>& nums) {
        vector<int> dp(nums.size(), INT_MAX);
        dp[0] = 0;
        for(int i = 0; i < nums.size(); i++) {
            for(int k = i+1; k < nums[i] + i + 1 && k < nums.size(); k++) {
                dp[k] = min(1 + dp[i], dp[k]);
            }
        }
        return dp[nums.size() - 1];
    }
};