package interviewQA.SlidingWindowAndTwoPointer;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r = 0;
        int count = 0;
        int maxLen = 0;
        while(r < n){
            if(arr[r] == 0){
                if(count < k){
                    count++;
                }else{
                    while(arr[l] == 1){
                        l++;
                    }
                    count--;
                    l++;
                    if(arr[r] == 0){
                        count++;
                    }
                }
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }

    public int longestOnesOptimised(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r = 0;
        int zeros = 0;
        int maxLen = 0;
        while(r < n){
            if(arr[r] == 0){
                zeros++;
            }
            if(zeros > k){
                if(arr[l] == 0){
                    zeros--;
                }
                l++;
            }

            if(zeros <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}
