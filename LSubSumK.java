import java.util.*;
public class LSubSumK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int sum=sc.nextInt();
        int maxLen=longest1(arr, n, sum);
        System.out.println("First"+maxLen);
        int maxlen2=longest2(arr, n, sum);
        System.out.println("Second"+maxlen2);

    }
    // Time Complexity - O(n^2)
    static int longest1(int[] arr, int n,int s){
        int maxLen=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==s){
                    maxLen=Math.max(maxLen,j-i+1);
                }
            
            }
        }
        return maxLen;
    }
    static int longest2(int[] arr, int n, int s) {
        int maxLen = 0;
        long sum = 0;
        Map<Long, Integer> preSum = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            
            if (sum == s) {
                maxLen = Math.max(maxLen, i + 1);
            }
            
            long rem = sum - s;
            if (preSum.containsKey(rem)) {
                int len = i - preSum.get(rem);
                maxLen = Math.max(maxLen, len);
            } 
            
            if (!preSum.containsKey(sum)) {
                preSum.put(sum, i);
            }
        }
        return maxLen;
    }
}
