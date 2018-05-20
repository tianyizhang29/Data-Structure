/*Design for problem2, in case of one of the matrix is natural number, the number of the other matrix sorted times could calculate
 * the Kendall tau distance. In this problem, for easy used, we can just input matrix 2 that can calculate the Kendall tau distance
 * between a natural number matrix and the other one. I used library of In function for easy read date in array.
 * It needs library of princeton.cs.introcs package*/
import edu.princeton.cs.introcs.In;
import java.io.*;

public class Problem2 {
    public static int counter = 0;
    public static void  mergeSort(int[]arr,int left, int right)
    {
        int middle = (right + left)/2;
        if(left < right){
            mergeSort(arr,left,middle);
            mergeSort(arr,middle+1,right);
            merge(arr, left , middle, right);
        }

    }
    private static void merge (int []arr, int left, int middle, int right)
    {
        int aux[] = new int [arr.length];
        int i = left, j = middle+1;

        int k = i;
        for (int m = 0; m<arr.length ;m++) //copy all the element to aux;
            aux[m] = arr[m];
        while (i <= middle && j <=right){ //when left part reach middle of right pointer reach right end, stop;
            if(aux[i]>aux[j]){ //should swap to item and then save into aux;
                arr[k++] = aux[j++];
                counter += middle - i + 1; // add 1 to difference;
            }
            else{
                arr[k++] = aux[i++];
            }
        }
        while( i <= middle){ //copy the left part left element to aux
            arr[k++] = aux[i++];
        }
        while (j <= right){ //copy the right part left element to aux
            arr[k++] = aux[j++];
        }
    }
    public static int[] input(String path){
        File fileIn = new File(path);
        In file = new In(fileIn);
        int data[] = file.readAllInts();
        return  data;
    }
    public static void main(String[] args){
        int test[] = input("data1.32768");
        long Stime = System.nanoTime();
        mergeSort(test,0,1023);
        long Etime = System.nanoTime();
        long during = (Etime-Stime)/1000; //change to us
        System.out.println(during);
    }
}
