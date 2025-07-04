import java.util.*;
public class leaders {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] x=new int[n];
        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
        }
        int[] ne=leader(x, n);
        for(int i=0;i<n;i++){
            System.out.print(ne[i]+" ");
        }
        

    }
    static int[] leader(int[] arr,int n){
        int max=-1;
        for(int i=n-1;i>=0;i--){
            int curr=arr[i];
            arr[i]=max;
            max=Math.max(curr,max);
        }
        return arr;
    }
}
