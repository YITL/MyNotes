package others;

/**
 * @author: yitl
 * @create: 2019-04-22
 */
public class CountingSort {

    public static void countingSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;
        int max = a[0];
        //拿到数组中的最大值
        for (int i = 1; i < n; ++i) {
            max = a[i] > max ? a[i] : max;
        }
        //初始化数组c
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }


        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i-1] + c[i];
        }

        int[] tmp = new int[n];
        for (int i = n-1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            tmp[index] = a[i];
            c[a[i]]--;
        }

        for (int i = 0; i < n; ++i) {
            a[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] test = {2,5,3,0,2,3,0,3};
        countingSort(test);
        for (int i : test) {
            System.out.print(i + " ");
        }
    }

}
