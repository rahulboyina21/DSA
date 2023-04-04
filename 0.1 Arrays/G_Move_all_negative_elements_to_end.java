import java.util.*;

public class G_Move_all_negative_elements_to_end{

    /**
     * Segregates positive and negative elements of an array.
     * Positive elements are placed at the start of the array, followed by negative elements.
     *
     * @param arr the input array to be segregated
     * @param n   the length of the input array
     */
    
    public static void segregateElements(int arr[], int n) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        // Iterate through array and add to respective lists
        for (int i : arr) {
            if (i >= 0) {
                positive.add(i);
            } else {
                negative.add(i);
            }
        }

        // Print all elements in positive array using forEach method and lambda expression
        positive.forEach(x -> System.out.print(x+" "));

        // Print all elements in negative array using forEach method and lambda expression
        negative.forEach(x -> System.out.print(x+" "));

        // Place positive elements at start of array
        int nidx = -1;
        boolean flag = false;
        
		/* Iterate through original array and replace with 
		 * positive numbers from the list, keeping track of 
		 * current index in list. Exit loop when all 
		 * positive numbers have been placed in original array. */
		 
		for (int i = 0; i < arr.length; i++) {
            flag = false;
            if (i <= positive.size() - 1) {
                arr[i] = positive.get(i);
                flag = true;
            }

            if (!flag) {
                nidx = i;
                break;
            }
        }

		/* Iterate through original array starting from where 
		 * we left off previously, replacing with negative numbers 
		 * from the list until all have been placed in original 
		 * array. */
		 
        if (!negative.isEmpty()) {
            for (int i = nidx; i < arr.length; i++) {
                arr[i] = negative.get(i - nidx);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, -1, 3, 2, -7, -5, 11, 6 };

        // Call the function to segregate elements
        segregateElements(array, array.length);

        // Print the updated array
        for (int i : array) {
            System.out.println(i);
        }
    }
}