package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-25
 */
public class Test50找到数组中第一个重复的数字 {

    /**
     * 借助hash表
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean[] arr = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (!arr[numbers[i]]) {
                arr[numbers[i]] = true;
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }


}
