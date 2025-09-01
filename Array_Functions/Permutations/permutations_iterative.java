import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static <T extends Comparable<T>> List<List<T>> generatePermutations(List<T> arr) {
        List<List<T>> permutations = new ArrayList<>();
        Collections.sort(arr);
        permutations.add(new ArrayList<>(arr));
        while (true) {
            int i = arr.size() - 2;
            while (i >= 0 && arr.get(i).compareTo(arr.get(i + 1)) >= 0) {
                i--;
            }
            if (i < 0) break;
            int j = arr.size() - 1;
            while (arr.get(j).compareTo(arr.get(i)) <= 0) {
                j--;
            }
            Collections.swap(arr, i, j);
            Collections.reverse(arr.subList(i + 1, arr.size()));
            permutations.add(new ArrayList<>(arr));
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 3, 2);
        List<List<Integer>> permutations = generatePermutations(arr);

        for (List<Integer> perm : permutations) {
            for (Integer elem : perm) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
