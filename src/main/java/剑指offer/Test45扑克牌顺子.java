package 剑指offer;

import java.util.Arrays;

/**
 * 模仿扑克，0作为赖子，判断是不是顺子
 *
 * @author: yitl
 * @create: 2019-03-23
 */
public class Test45扑克牌顺子 {

    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) return false;
        Arrays.sort(numbers);
        int tmp = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) tmp++;
            else {
                if (numbers[i] == numbers[i+1]) return false;
                tmp = tmp - (numbers[i+1] - numbers[i] + 1);
                if (tmp < 0) return false;
            }
        }
        return true;
    }

}
