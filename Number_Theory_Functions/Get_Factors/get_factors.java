import java.util.ArrayList;

public class get_factors{
    public static ArrayList<Integer> get_factor(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        double root = Math.floor(Math.sqrt(n));
        for (int i=1; i<=root;i++){
            if ( n%i ==0){
                ans.add(i); //pushing the factors <= (root) into an ArrayList
                if ( i != (n/i)){
                    ans.add(n/i);  // pushing the corresponding factors which are greater than root(n)
                }
            }
        }
        return ans;
    }

    public static void main(String args[]){
        System.out.println(get_factor(4)); // sample input 1
        System.out.println(get_factor(20)); // sample input 2
    }
}
