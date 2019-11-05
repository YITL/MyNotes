package 剑指offer;

public class Test09变态跳台阶 {

    //隔板问题,结果 = C(5,0) + C(5,1) + C(5,2) + C(5,3) + C(5,4) + C(5,5) = 2的五次方
    public int JumpFloorII(int target){
        return (int) Math.pow(2, (target - 1));
    }

}
