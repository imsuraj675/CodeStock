public class upperBound {

    public static int u_bound(int[] a, int key) {
        int l = 0, r = a.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] <= key) {
                ans = Math.max(ans, mid);
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        if (ans != -1 && a[ans] == key) return ans;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 2, 3, 5};
        int key = 2;
        int UBound = u_bound(a, key);
        if (UBound == -1) {
            System.out.println("The number does not exist.");
        }
        else {
            System.out.printf("Upper Bound of '%d' = %d\n", key, UBound);
        }
    }
}