public class CountingSort {
    public static int[] sort(int entries, int maxVal) {
        int output[] = new int[entries];
        int key[] = new int[maxVal + 1];
        int currentIndex = 0;
        key[1] = 1024;
        key[11] = 2048;
        key[111] = 4096;
        key[1111] = 1024;
        for (int num = 1; num <= maxVal; num++)
            for (int i = 0; i < key[num]; i++)
                output[currentIndex++] = num;
        return output;
    }

    public static void main(String[] args){
        int test[] =sort(8192,1111);
        for(int i =0;i<8192;i++)
        System.out.print(test[i]+" ");
    }
}
