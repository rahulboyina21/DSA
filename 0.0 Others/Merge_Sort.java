/*
 * The Merge sort is an Divide and Conquer Algorithm 
 * 
 * 1st Step (Divide portion of the Algorithm)
 * 
 * Divide the given array into two halves and recuresviley repeat the process until you end with 
 * atomic element.
 * 
 * 2nd Step
 * 
 * Merge the one portion of the elements of one array with another once they are compared placed 
 * accordingly then repeat the step with all the elements of all the sub arrays .
 * 
 * Visualize = https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/visualize/
 */


import java.util.*;
public class Merge_Sort {


    // This is the method which will be called recuresivly for each half of the array
    private static void MS(int[] array) {
        
        // To find the size of the input array passed to the method.

        int indexlength = array.length;

        //If we have recuresivly called this method and we reached to the last element in the array
        //We need to return that element as this acts as an Base Condition.

        if(indexlength<2)
        {
            // Here we are returing back to the recursion call 
            return;
        }

        else{

            // Ok if our array has more than one element so we need to divide it furthur small atomic units
            // For that we need to divide our current array into the half and then pass it as the input
            // to the same MergeSort Function

            int midIndex =  indexlength/2;

            // Now create the two arrays to store the left and Right parts of the Orginal array passed.

            int leftArray[] = new int[midIndex];
            
                // Now we have created the left array of length till the midpoint of the orginal array.

            int rigthArray[] = new int[indexlength-midIndex];

                // We cannot take the midIndex for the RightArray one as well Why ?
                // If we have odd number of elements like 9 element then mid point is 4
                // If i use the mid point for the left and right halfs then total number of elements are
                // Only 8 but inactual we should be having nine number of elements.

            // So we have the Left Sub Array and Right Sub Array so what's Next ?
                // We need to make these SUB Arrays to the atomic in size so we need divide them even furtur ?
                // This is achieved by passing those sub arrays back to the same MergeSort Function recursively.

            // Ok now We have sub arrays but what about values in them Who Will Assign How it will be Assigned
                // Loop over orginal array and assign values 
            
            for (int i=0;i<indexlength;i++)
            {
                if(i<midIndex)
                {
                    leftArray[i]=array[i];
                }
                else
                {
                    rigthArray[i-midIndex]=array[i];
                }
            }


            MS(leftArray);
            // IT will be super confusing of what this is actally doing 
            // Let me explain 
                // We are passing left part of the array to the Orginal method MS where it will be treated 
                // as an new Array it will not be considering Acha this array is the left sub part of the
                // previously array i have worked on there will be no clue like that .
                // When This array is divided furtur then also left sub part of it will be divided furtur
                // Initally then once it reaches to the base case then right sub part of the second smallest
                // Atomic Group will be solved but why like that ?

                //  Ls(3) RS(pending) , Ls(2) RS(pending) , Ls(1) (now Return this value) RS(pending)=> will be executed 
                // The right subpart which is executed above is the part of left subpart of (n-2) when all these are executed 
                // when it reaches to (n-n+1) there all the process will be repeated for the Right side of the Array

            MS(rigthArray);
            // This will be executed once all the left Array parts are executed.
            
            Merge(array,leftArray,rigthArray);

        }
    }

    private static void Merge(int[] OA,int[] LA,int[] RA)
    {
        // Now we have to merge left and right ok lets do it then ?
        // If we merge it just like LA+RA then what is the point of dividing all these elements to atomic ?
        // So what's needed to be done now ?
        // We need to compare each element in the LA and RA and place the elements accordingly in Original Array
        // LA[0] < RA[0] then place it in the OA[0] same goes for all the elements 

        int i=0,j=0,k=0;

        int lal=LA.length , ral=RA.length, oal=OA.length;

        // I want to compare the elements from the left sub array to right sub array
        // I need to traverse through Left,Right sub array then i can go with loop with in loop 
        // or moving with an incremental order to compare using one loop and compare each element and 
        // increment only if that element is been pushed into the orginal array.

        while(i<lal && j<ral)
        {
            // If the element in the Left Sub Array is less than element in the Right Sub Array 
            // Then push that element(replace) to the orginal array keeping track of the index.

            if(LA[i]<=RA[j])
            {
                // Assigning element to the orginal array 
                OA[k]=LA[i];
                // Incrementing the index of the left Sub Array as that element has been pushed 
                // Now let's verify the other elements.
                i++;
                // The j++ is complete blunder why ?
                // See i have compared the element in the Left Sub Array and pushed it how can be so sure
                // we need to next index in the Right Sub Array and more over we haven't pushed it yet 
                // Without perfroming appropiate action on it what is the point of skipping it 
                // the inital element in the Right Sub Array has to be verfied and compared with other
                // elements as well so we shouldn't increment it .

                // Error ->                      j++;
                
                // The Orginal Array once been occupied with an element in the certain index we will be moving
                // the index tracker K to the next possible index .

                k++;
            }

            // If Left Sub Array element is not less than or equal to the right sub array element 
            // the right sub array element will be less than the left sub array element 

            else
            {
                OA[k]=RA[j];
                k++;
                j++;
            }

            // Ok now are done ? is all comparsions and pushing are ok ?
            // No but how ? Let me explain 
            // See if all the elements in the Left Sub Array is less than the first element of the right 
            // Sub Array then Left Sub array index will be incremented and might reach out of the it's actual
            // Length. As per looping condition while(i<lal && j<ral) i is now greater than lal so the loop will
            // Break but what about Right Sub Array Elements they are ignored now right they are also needed 
            // be included but do they needed to sorted or compared with NOOOOOOOOOOOOOOOOOOOOOOOOOOOOO need
            // but why it is need not to be sorted the Answer is they themself are sorted now we are comparing
            // Two SORTED arrays . So it's an straight forward push.
        }
        while(i<lal)
        {  
            OA[k]=LA[i];
            k++;
            i++;

        }
        while(j<ral)
        {
            OA[k]=RA[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        Random rd = new Random();

        int array[]=
        new int[10000000];

        for(int i=0;i<array.length;i++)
        {
            array[i]=rd.nextInt(1000000000);
        }

        // System.out.println("Array Before Sorting ");

        int ctr=0;

        // for(int i:array)
        // {
        //     System.out.println("Index = "+ctr+" is "+i);
        //     ctr++;
        // }
        
        long start=System.nanoTime();

        MS(array);
        
        long end = System.nanoTime();

        System.out.println("Array After Sorting ");
        
        System.out.println("Time taken for Execution is = "+(end-start));

        ctr=0;

        // for(int i:array)
        // {
        //     System.out.println("Index = "+ctr+" is "+i);
        //     ctr++;
        // }


    }
}
