package interviewQA.SlidingWindowAndTwoPointer;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int x = subarrayCount(nums,k);
        int y = subarrayCount(nums,k-1);
        return x-y;
    }

    public int subarrayCount(int[] nums, int k){
        if(k < 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int noOfSubs = 0;
        int n = nums.length;
        while(r < n){
            if(map.containsKey(nums[r])){
                int count = map.get(nums[r]);
                count = count + 1;
                map.put(nums[r],count);
            }else{
                map.put(nums[r],1);
            }

            while(map.size() > k){
                int count = map.get(nums[l]);
                count = count - 1;
                map.put(nums[l],count);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                }
                l++;
            }
            if(map.size() <= k){
                noOfSubs = noOfSubs + (r-l+1);
            }
            r++;
        }
        return noOfSubs;
    }
}
