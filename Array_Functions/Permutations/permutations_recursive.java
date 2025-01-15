import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private static <T> void generatePermutations(List<T> arr, int l, int r, List<List<T>> result) {
        if (l == r) {
            result.add(new ArrayList<>(arr));
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                generatePermutations(arr, l + 1, r, result);
                swap(arr, l, i);
            }
        }
    }

    private static <T> List<List<T>> getPermutations(List<T> arr) {
        List<List<T>> result = new ArrayList<>();
        generatePermutations(arr, 0, arr.size() - 1, result);
        return result;
    }

    private static <T> void swap(List<T> arr, int i, int j) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(3);
        List<List<Integer>> permutations = getPermutations(arr);

        for (List<Integer> perm : permutations) {
            for (Integer elem : perm) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}

