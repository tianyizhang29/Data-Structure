import edu.princeton.cs.algs4.Quick;

import java.io.*;
import java.util.Arrays;

public class QuickSort {
    public int counter;
    public QuickSort(){
        counter =0;
    }
    public  void sort(int []arr, int left, int right){
        int midVal,temp;
        if(right<=left)
            return;
        int middle = (left+right)/2;
        midVal = Math.max(Math.min(arr[left],arr[middle]), Math.min(Math.max(arr[left],arr[middle]),arr[right]));//find middle value;
        temp = arr[left]; //swap the value of midVal and Left value;
        arr[left] = midVal;
        if(midVal == arr[middle])
            arr[middle] = temp;
        else if(midVal == arr[right])
            arr[right] = temp;
        int j = partition(arr,left,right);
        sort(arr,left,j);
        sort(arr,j+1,right);
    }
    public  void sortCut7(int []arr, int left, int right){
        int midVal,temp;
        if(right<=left)
            return;
        int middle = (left+right)/2;
        midVal = Math.max(Math.min(arr[left],arr[middle]), Math.min(Math.max(arr[left],arr[middle]),arr[right]));//find middle value;
        temp = arr[left]; //swap the value of midVal and Left value;
        arr[left] = midVal;
        if(midVal == arr[middle])
            arr[middle] = temp;
        else if(midVal == arr[right])
            arr[right] = temp;
        int j = partition(arr,left,right);
        if(j-left<=7)
            insertionSort(arr,left,j);
        else
            sortCut7(arr,left,j);
        if(right-j-1 <=7)
            insertionSort(arr,j+1,right);
        else
            sortCut7(arr,j+1,right);
    }
    public  void cut7(int []arr, int left, int right){
        int j = partition(arr,left,right);
        if(j-left<=7)
            insertionSort(arr,left,j);
        else
            cut7(arr,left,j);
        if(right-j-1 <=7)
            insertionSort(arr,j+1,right);
        else
            cut7(arr,j+1,right);
    }
    private  int partition(int[]arr,int left, int right){
        if(left>=right)
            return left;
        int i = left;
        int j = right+1;
        int temp;
        while(i<j){//arr[left] is pivot;
            while(arr[left]>=arr[++i] ) { //find left part swap item;
                if(i == right)
                    break;
                else counter++;

            }
            while(arr[left]<=arr[--j] )//find right part swap item;
                if(j == left)
                    break;
                else counter++;
            if(i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
        }
        temp =arr[left];
        arr[left]=arr[j];
        arr[j]=temp;
        return j;
    }
    /*Insertion Sort for cutoff*/
    public  void insertionSort(int arr[],int left, int right){
        for(int i =left;i<=right;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=left && arr[j]>key){
                arr[j+1] =arr[j];
                j --;
                counter++;
            }
            arr[j+1] = key;
            counter++;
        }
    }
    public  int[] input(String path){
        File fileIn = new File(path);
        In file = new In(fileIn);
        int data[] = file.readAllInts();
        return  data;
    }
    public static void main(String[] args){

        QuickSort test2 = new QuickSort();
        int b[] = test2.input("data1.32768");
        test2.sort(b,0,b.length-1);
        System.out.println("medianOf3: " +test2.counter);
        QuickSort test3 = new QuickSort();
        int c[] = test3.input("data1.32768");
        test3.cut7(c,0,c.length-1);
        System.out.println("cutoff7: " +test3.counter);
        QuickSort test1 = new QuickSort();
        int a[]= test1.input("data1.32768");
        test1.sortCut7(a,0,a.length-1);
        System.out.println("medianOf3-cutoff7: " + test1.counter);
    }
}
