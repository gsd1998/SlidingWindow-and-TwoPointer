package interviewQA.SlidingWindowAndTwoPointer;

import java.util.HashMap;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int x = subarrayCount(s,3);
        int y = subarrayCount(s,2);
        return x-y;
    }

    public int subarrayCount(String s, int k){
        if(k < 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int noOfSubs = 0;
        int n = s.length();
        while(r < n){
            if(map.containsKey(s.charAt(r))){
                int count = map.get(s.charAt(r));
                count = count + 1;
                map.put(s.charAt(r),count);
            }else{
                map.put(s.charAt(r),1);
            }

            while(map.size() > k){
                int count = map.get(s.charAt(l));
                count = count - 1;
                map.put(s.charAt(l),count);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
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

    //This uses the approach of finding the index where the substring ends but its a valid substring
    public int numberOfSubstringsOptimised(String s) {
        int noOfSubs = 0;
        int[] lastSeenIndex = {-1,-1,-1};
        for(int i = 0; i <= s.length()-1; i++){
            lastSeenIndex[s.charAt(i) - 'a'] = i;
            if(lastSeenIndex[0] != -1 && lastSeenIndex[1] != -1 && lastSeenIndex[2] != -1){
                noOfSubs = noOfSubs +  Math.min(Math.min(lastSeenIndex[0], lastSeenIndex[1]), lastSeenIndex[2]) + 1;
            }
        }
        return noOfSubs;
    }
}
