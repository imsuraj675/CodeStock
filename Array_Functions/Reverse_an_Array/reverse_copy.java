import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static <T> List<T> reverseInPlaceAndReturnCopy(List<T> vc) {
        int n = vc.size();
        int low = 0, high = n - 1;
        while (low < high) {
            T temp = vc.get(low);
            vc.set(low, vc.get(high));
            vc.set(high, temp);
            low++;
            high--;
        }
        return new ArrayList<>(vc);  
    }

    public static void main(String[] args) {
        List<Integer> vc = Arrays.asList(1, 2, 3);
        List<Integer> rev = reverseInPlaceAndReturnCopy(new ArrayList<>(vc));
        for (int i : rev) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

