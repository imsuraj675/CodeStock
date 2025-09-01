import java.util.*;
public class Prefix {
    public static int[] prefixSum(int[] arr, int n) {
        int[] res = new int[n];
        res[0] = arr[0];
        for(int i=1;i<n;i++) {
            res[i] = res[i-1] + arr[i];
        }
        return res;
    }

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        
        int[] preSum = prefixSum(arr, n);

        for(int i=0;i<n;i++) {
            System.out.print(preSum[i] + " ");
        }
        System.out.println();
    }
}