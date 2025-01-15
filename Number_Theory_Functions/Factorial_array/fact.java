import java.util.*;

public class FactorialModulo {

    public static List<Long> factorial(int n, int p) {
        List<Long> res = new ArrayList<>(Collections.nCopies(n + 1, 1L));
        for (int i = 1; i <= n; i++) {
            res.set(i, (res.get(i - 1) * i) % p);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 25, p = 29;
        List<Long> res = factorial(n, p);

        for (Long i : res) {
            System.out.print(i + " ");
        }
    }
}
