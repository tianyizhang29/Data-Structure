public class Sort {
    public static int insertion(int[]a)
    {   int counter =0 ; /*count comparision times*/
        int size= a.length;
        for(int i= 0;i<size;i++)
        {
            int key = a[i];
            int j = i-1;
            while (j>=0 && a[j]>key) //from end to the first to make comparision
            {
                a[j+1] = a[j];
                j = j-1;
                counter++;
            }
            counter++;
            a[j+1] = key;
        }
        return counter;
    }
    public static int shell(int[] a )
    {
        int counter =0;
        int size = a.length;
        /*increment 7,3,1*/
        for (int n = 3; n > 0; n--) {
            int gap = (int) Math.pow(2, n)-1; //gap
            for(int i = gap;i<size;i++)// from the gap to calculate
            {
                int key = a[i];
                int j = i-gap;
                while (j>=0 && a[j]>key)
                {
                    counter ++;
                    a[j+gap] = a[j];
                    j-=gap;
                }
                counter++;
                a[j+gap] = key;
            }
        }
        return counter;
    }
    public static void main(String[] arg)
    {
        int max = 20000;
        int arr1[] = new int [max];/*arr1 and arr2 are arrays with same value*/
        int arr2[] = new int [max];
        for(int i = 0; i<max;i++)
        {
            arr1[i] = (int) (1000*Math.random());
        }
        System.arraycopy(arr1,0,arr2,0,max);
        int countInsertion = insertion(arr1);
        int countShell = shell(arr2);
        System.out.println("Insertion: "+countInsertion);
        System.out.println("Shell: "+countShell);

    }
}
