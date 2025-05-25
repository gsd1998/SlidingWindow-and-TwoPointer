package interviewQA.SlidingWindowAndTwoPointer;

import java.util.HashMap;

public class CountNumberOfNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int subArrCnt = 0;
        int oddCount = 0;
        map.put(0,1);
        for(int i = 0; i <= nums.length-1; i++){
            if(nums[i] % 2 != 0){
                oddCount++;
            }
            int noOfOddsWanted = oddCount - k;
            if(map.containsKey(noOfOddsWanted)){
                int cnt = map.get(noOfOddsWanted);
                subArrCnt = subArrCnt + cnt;
            }
            if(map.containsKey(oddCount)){
                map.put(oddCount, map.get(oddCount)+1);
            }
            else{
                map.put(oddCount, 1);
            }
        }
        return subArrCnt;
    }

    //Optimal approach using (sum == k) => (sum <= k) - (sum <= k-1)
    public int numberOfSubarraysOptimised(int[] nums, int k) {
        int x = numSubarray(nums,k);
        int y = numSubarray(nums,k-1);
        return x-y;
    }

    public int numSubarray(int[] nums, int k){
        if(k < 0){
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int r = 0;
        int oddCount = 0;
        int countOfSubs = 0;
        while(r < n){
            oddCount = oddCount + (nums[r] % 2);
            while(oddCount > k){
                oddCount = oddCount - (nums[l] % 2);
                l++;
            }
            if(oddCount <= k){
                countOfSubs = countOfSubs + (r-l+1);
            }
            r++;
        }
        return countOfSubs;
    }


}
