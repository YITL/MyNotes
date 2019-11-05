package 剑指offer;

public class Test67剪绳子 {

    public int cutRope(int target) {
        //排除基本的几种情况
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;

        //这里的赋值可以看作标志量,因为小于4的入参都已经处理过了,这里的赋值只是为了方便计算
        //包括数组长度要+1,也是为了计算
        //可以理解为有效值就是从索引4开始,到target索引,这之间的数据
        int[] results = new int[target+1];
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;

        for (int i = 4; i <= target; i++) {
            //剑指offer书上是遍历,但我发现每次都是等于中间值的时候最大
            //于是直接改成中间值,发现没有问题
            //具体原理和贪心应该差不多,用我自己的理解就是数据越散越好
            int j = i/2;
            results[i] = results[j]*results[i-j];
        }
        return results[target];
    }

}
