package interviewQA.SlidingWindowAndTwoPointer;

public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int x = numSubarray(nums,goal);
        int y = numSubarray(nums,goal-1);
        return x-y;
    }

    public int numSubarray(int[] nums, int goal){
        if(goal < 0){
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while(r < n){
            sum = sum + nums[r];
            while(sum > goal){
                sum = sum - nums[l];
                l++;
            }
            if(sum <= goal){
                count = count + (r-l+1);
            }
            r++;
        }
        return count;
    }
}
