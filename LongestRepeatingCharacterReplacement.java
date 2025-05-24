package interviewQA.SlidingWindowAndTwoPointer;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int[] hashArr = new int[27];
        while(r < n){
            hashArr[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hashArr[s.charAt(r) - 'A']);

            while((r-l+1) - maxFreq > k){
                maxFreq = 0;
                hashArr[s.charAt(l) - 'A']--;
                for(int i = 0; i <= 26; i++){
                    maxFreq = Math.max(maxFreq, hashArr[i]);
                }
                l++;
            }
            if((r-l+1) - maxFreq <= k){
                maxLen = Math.max(maxLen, (r-l+1));
            }
            r++;
        }
        return maxLen;
    }

    public int characterReplacementOptimised(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int[] hashArr = new int[27];
        while(r < n){
            hashArr[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hashArr[s.charAt(r) - 'A']);
            if((r-l+1) - maxFreq > k){
                hashArr[s.charAt(l) - 'A']--;
                l++;
            }
            if((r-l+1) - maxFreq <= k){
                maxLen = Math.max(maxLen, (r-l+1));
            }
            r++;
        }
        return maxLen;
    }
}
