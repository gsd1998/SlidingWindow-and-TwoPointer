package interviewQA.SlidingWindowAndTwoPointer;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int l = 0;
        int r = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int startIndex = -1;
        int[] hashArr = new int[256];
        for(int i = 0; i < m; i++){
            hashArr[t.charAt(i)]++;
        }
        while(r < n){
            if(hashArr[s.charAt(r)] > 0){
                count++;
            }
            hashArr[s.charAt(r)]--;
            while(count == m){
                if((r-l+1) < minLength){
                    minLength = r-l+1;
                    startIndex = l;
                }
                hashArr[s.charAt(l)]++;
                if(hashArr[s.charAt(l)] > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        if(startIndex == -1){
            return "";
        }
        String str = s.substring(startIndex, startIndex+minLength);
        return str;
    }

}
