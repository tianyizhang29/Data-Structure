import java.io.*;
public class MergeSort {
    public int counter; //count for comparison;
    public MergeSort(){
        counter =0;
    }
        public  void  mergeSortUp(int[]arr,int left, int right)
        {
            int middle = (right + left)/2;
            if(left < right){
                mergeSortUp(arr,left,middle);
                mergeSortUp(arr,middle+1,right);
                merge(arr, left , middle, right);
            }

        }
        public  void mergeSortBottom(int []arr){
        int width;
        for (width =1;width<arr.length;width *=2){
            for(int i = 0;i<arr.length;i += width*2){
                int left = i;
                int middle = i+ width-1;
                int right = i + width*2-1;
                if(right > arr.length-1) //in case the size of array is not power of 2;
                    right = arr.length-1;
                merge(arr, left,middle,right);
            }
        }
    }
        private  void merge(int []arr, int left, int middle, int right)
        {
            int aux[] = new int [arr.length];
            int i = left, j = middle+1;

            int k = i;
            for (int m = 0; m<arr.length ;m++) //copy all the element to aux;
                aux[m] = arr[m];
            while (i <= middle && j <=right){ //when left part reach middle of right pointer reach right end, stop;
                if(aux[i]>aux[j]){ //should swap to item and then save into aux;
                    arr[k++] = aux[j++];
                    counter ++;
                }
                else{
                    arr[k++] = aux[i++];
                    counter ++;
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
            //int test[] =
            MergeSort test = new MergeSort();
            int a[] = input("data0.32768");
            test.mergeSortUp(a,0,a.length-1);
            System.out.println("Up-Bottom: "+test.counter);
            MergeSort test2 = new MergeSort();
          /*  int b[] = input("data1.32768");
            test2.mergeSortBottom(b);
            //for(int i= 0;i<a.length;i++)
            System.out.println("Bottom-Up: "+test2.counter);*/
        }
}
