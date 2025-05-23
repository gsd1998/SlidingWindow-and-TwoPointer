package interviewQA.SlidingWindowAndTwoPointer;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int len = 0;
        for(int i = 0; i <= n-1; i++){
            while(map.containsKey(s.charAt(i))){
                map.remove(s.charAt(l));
                l++;
            }
            map.put(s.charAt(i), i);
            len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            r++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringUsingHashArray(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int len = 0;
        int[] hashArr = new int[256];
        for(int i = 0; i < 256; i++){
            hashArr[i] = -1;
        }
        while(r < n){
            if(hashArr[s.charAt(r)] != -1){
                if(hashArr[s.charAt(r)] >= l){
                    l = hashArr[s.charAt(r)] + 1;
                }
            }
            len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hashArr[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
}
