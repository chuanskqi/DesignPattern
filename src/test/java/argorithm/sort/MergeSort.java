package argorithm.sort;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] a = new int[] {0,1,1,2,2,3,3,4,6,7};
        int[] b = new int[] {0,2,3,4,8,9};

        int[] c = merge(a, b);
        System.out.println(c.length);
        System.out.println(Arrays.toString(c));
    }

    public static void mergeSort(int a[], int n) {



    }

    public static int[] merge(int[] a, int[] b) {
        int[] merge = new int[a.length + b.length];
        int aCursor = 0;
        int bCursor = 0;

        for (int i = 0; i < merge.length; i++) {
            if (aCursor == a.length) {
                merge[i] = b[bCursor ++];
            } else if (bCursor == b.length) {
                merge[i] = a[aCursor ++];
            } else if (a[aCursor] <=  b[bCursor]) {
                merge[i] = a[aCursor++];
            } else {
                merge[i] = b[bCursor++];
            }
        }
        return merge;
    }
}
