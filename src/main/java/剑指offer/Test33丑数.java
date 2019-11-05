package 剑指offer;

import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author: yitl
 * @create: 2019-03-18
 */
public class Test33丑数 {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7){
            return index;
        }
        int p2 = 0, p3 = 0, p5 = 0, num = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(num);
        while (index-- > 1){
            num = Integer.min(list.get(p5)*5, Integer.min(list.get(p2)*2, list.get(p3)*3));
            if (list.get(p2)*2 == num) p2++;
            if (list.get(p3)*3 == num) p3++;
            if (list.get(p5)*5 == num) p5++;
            list.add(num);
        }
        return num;
    }
}
