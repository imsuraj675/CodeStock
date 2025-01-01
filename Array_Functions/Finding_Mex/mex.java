
import java.util.*;

public class mex {

static int mex(int[] arr)
{

	Arrays.sort(arr);

	int mex = 0;
	for (int i= 0; i < arr.length; i++) {
	if (arr[i] == mex) {
		mex += 1;
	}
	}
	return mex;
}

public static void main(String[] args)
{
	int[] arr = { 1, 0, 2, 4 };

	System.out.print(mex(arr));
}
}

