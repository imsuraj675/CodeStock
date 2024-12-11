package generate_all_subsequences;

import java.util.ArrayList;

public class gen_subseq {

    public static void helper(String s, int n, int i, StringBuilder sub, ArrayList<String> container) {
        // Base case: when we reach the end of the string
        if (i >= n) {
            container.add(sub.toString());
            return;
        }
        
        // Include the current character in the subsequence
        sub.append(s.charAt(i));
        helper(s, n, i + 1, sub, container);
        
        // Backtrack: exclude the current character
        sub.deleteCharAt(sub.length() - 1);
        helper(s, n, i + 1, sub, container);
    }

    public static ArrayList<String> func_body(String s) {
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sub = new StringBuilder();
        helper(s, n, 0, sub, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcd"; // Example input
        ArrayList<String> allSubsequences = func_body(s);

        // Print all subsequences
        for (String subsequence : allSubsequences) {
            System.out.println(subsequence);
        }
    }
}
