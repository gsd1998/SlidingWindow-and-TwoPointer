package interviewQA.SlidingWindowAndTwoPointer;

public class MaximumPointsObtainedFromCards {

    public static void main(String[] args) {
        int[] cardPoints = {6,2,3,4,7,2,1,7,1};
        int k = 4;
        int result = maxScore(cardPoints, k);
        System.out.println(result);//16
    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = n-k;
        int r = n-1;
        int sum = 0;
        for(int i = l; i <= r; i++){
            sum += cardPoints[i];
        }
        int maxSum = sum;
        while(l < n){
            sum -= cardPoints[l];
            l++;
            r++;
            r = r % n;
            sum += cardPoints[r];
            maxSum  = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
