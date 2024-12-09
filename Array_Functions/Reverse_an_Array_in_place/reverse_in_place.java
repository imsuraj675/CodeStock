import java.util.ArrayList;
import java.util.List;

publc class reverse_in_place {
    public static <T> void reverseInPlace(List<T> arr){
        int n = arr.size();
        for(int i=0; i<n/2; i++){ 
	    //swap elements at positions i and n-1-i
            T temp = arr.get(i);
            arr.set(i, arr.get(n-1-i));
            arr.set(n-1-i, temp);
        }
        return;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>() ;
        arr.add(1);
        arr.add(2);
        arr.add(3);
        
        reverseInPlace(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}