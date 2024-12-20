import java.util.*;

class SparseTable {
    private int[][] lookup;
    private int[] binLog;
    private int n;
    private String funcName;

    private int operation(int x, int y) {
        switch (funcName) {
            case "min":
                return Math.min(x, y);
            case "max":
                return Math.max(x, y);
            case "gcd":
                return gcd(x, y);
            case "lcm":
                return lcm(x, y);
            case "and":
                return x & y;
            case "or":
                return x | y;
            default:
                throw new IllegalArgumentException("Unsupported function name: " + funcName);
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a * b) / gcd(a, b);
    }

    public void build(int[] arr, int size, String func) {
        funcName = func.toLowerCase();
        n = size;

        binLog = new int[n + 1];
        binLog[1] = 0;
        for (int i = 2; i <= n; i++) {
            binLog[i] = binLog[i / 2] + 1;
        }

        int maxLog = binLog[n];
        lookup = new int[n][maxLog + 1];

        for (int i = 0; i < n; i++) {
            lookup[i][0] = arr[i];
        }

        for (int k = 1; k <= maxLog; k++) {
            for (int i = 0; i + (1 << k) <= n; i++) {
                lookup[i][k] = operation(lookup[i][k - 1], lookup[i + (1 << (k - 1))][k - 1]);
            }
        }
    }

    public int query(int L, int R) {
        int k = binLog[R - L + 1];
        return operation(lookup[L][k], lookup[R - (1 << k) + 1][k]);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        String funcName = sc.next();

        SparseTable st = new SparseTable();
        st.build(arr, n, funcName);

        int q = sc.nextInt();
        while (q-- > 0) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            System.out.println(st.query(L, R));
        }

        sc.close();
    }
}
