package generate_all_substrings;

public class gen_substr{
    public static void func_body(String str) {
        int n = str.length();
        // Generating all substrings
        for (int i = 0; i < n; i++) {         
            for (int j = i; j < n; j++) {     
                System.out.println(str.substring(i, j + 1)); 
            }
        }
    }

    public static void main(String[] args) {
        String input = "abcd"; // Example input
        // Call the function with the string as an argument
        func_body(input);
    }
}
