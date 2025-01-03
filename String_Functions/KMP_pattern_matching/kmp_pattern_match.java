import java.util.ArrayList;

class kmp_pattern_match {
    
    static void getLps(String pattern, int[] lps) {
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) { //characters match, increase len
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0) len = lps[len - 1];
                else {
                    lps[i] = 0;     //couldn't find a prefix that is also suffix, move forward
                    i++;
                }
            }
        }
    }

    static ArrayList<Integer> search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        ArrayList<Integer> ans = new ArrayList<>();
        if(m>n) return ans;   //pattern larger than text, no match can be found. return empty list.

        int[] lps = new int[m];
        getLps(pattern, lps);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {        //match found
                    ans.add(i - m);  //add starting index to list
                    j = lps[j - 1];  //adjust j using lps to begin finding next match
                }
            }
            else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return ans; 
    }

    public static void main(String[] args) {
        String text = "ababacabab"; 
        String pattern = "aba"; 

        ArrayList<Integer> ans = search(text, pattern);
        for (int idx : ans) 
            System.out.print(idx + " ");
    }
}