public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        //if (len == 1 && nums[0] == 0) return 1;
        //if (len == 1 && nums[0] == 1) return 0;
        
        int sum = 0, nsum = 0;
        int i = 0;
        for (i = 0; i < len; i++){
            nsum += nums[i];
            sum += i;
        }
        sum += i;
        return sum - nsum;
        
    }
}
