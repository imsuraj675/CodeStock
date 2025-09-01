import java.util.ArrayList;
import java.util.List;

/*
	(c) Aritro 'sortira' Shome
 */
public class Permutation {

    public static List<String> generatePermutations(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, new StringBuilder(), new boolean[s.length()], result);
        return result;
    }

    private static void backtrack(String s, StringBuilder path, boolean[] used, List<String> result) {
        if (path.length() == s.length()) {
            result.add(path.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            path.append(s.charAt(i));
            backtrack(s, path, used, result);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    // Example usage:
    public static void main(String[] args) {
        List<String> permutations = generatePermutations("abc");
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}
