import java.util.*;

public class H_Missing_Number {
    

    public static int missingNumber(int A[], int N)
    {
         // Your code goes here
         
         Arrays.sort(A);
         int len=A.length;
         
         for(int i=0;i<len;i++)
         {
            int x=A[i] , y=i+1;
            // System.out.println("A[i] = "+x+" = "+" i+1 "+y);
             if(x!=y)
             {
                return y;
             }
         }
         
         return -1;
    } 

    public static void main(String[] args) {
        
        int[] arr = {1,4,3};

        int x=missingNumber(arr,arr.length);

        System.out.println();
        System.out.println(x);

    }
}
