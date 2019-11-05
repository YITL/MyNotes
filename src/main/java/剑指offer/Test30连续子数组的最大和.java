package 剑指offer;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @author: yitl
 * @create: 2019-03-17
 */
public class Test30连续子数组的最大和 {

    boolean isInvalid = false;

    /**
     * 动态规划，f(i)表示以第i个点结尾的最大值，只有两种情况：
     * 如果f(i-1)小于0的话，那f(i)就等于arr[i]
     * 如果f(i-1)大于0的话，f(i)就等于arr[i]+f(i)
     * 然后借助一个指针，始终缓存f(i)的最大值
     * 关键点就是找好在每个节点，所有状态的可能
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            isInvalid = true;
            return 0;
        }

        int res = 0;
        int maxRes = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; ++i) {
            if (res <= 0) {
                res = array[i];
            } else {
                res += array[i];
            }
            maxRes = res > maxRes ? res : maxRes;
        }

        return maxRes;
    }

}
