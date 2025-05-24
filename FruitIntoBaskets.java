package interviewQA.SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int l = 0;
        int r = 0;
        int len = 0;
        int maxLen = 0;
        int typeTaken = 0;
        int n = fruits.length;

        while(r < n){
            if(!map.containsKey(fruits[r])){
                if(typeTaken < 2){
                    typeTaken++;
                }else{
                    int minIndex = Integer.MAX_VALUE;
                    int minKey = -1;
                    for(Map.Entry<Integer,Integer> mp : map.entrySet()){
                        if(mp.getValue() < minIndex){
                            minIndex = mp.getValue();
                            minKey = mp.getKey();
                        }
                    }
                    map.remove(minKey);
                    l = minIndex + 1;
                }
            }
            map.put(fruits[r],r);
            len = r - l + 1;
            maxLen = Math.max(len,maxLen);
            r++;
        }
        return maxLen;
    }


    public int totalFruitAnotherApproach(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int l = 0;
        int r = 0;
        int len = 0;
        int maxLen = 0;
        int n = fruits.length;
        while(r < n){
            if(map.containsKey(fruits[r])){
                int val = map.get(fruits[r]);
                map.put(fruits[r], val+1);
            }else{
                map.put(fruits[r],1);
            }

            if(map.size() > 2){
                int val1 = map.get(fruits[l]);
                val1 = val1-1;
                map.put(fruits[l], val1);
                if(map.get(fruits[l]) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size() <= 2){
                len = r - l + 1;
                maxLen = Math.max(len,maxLen);
            }
            r++;
        }
        return maxLen;
    }
}
