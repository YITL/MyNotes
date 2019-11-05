package 剑指offer;

public class Test10矩形覆盖 {

    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        int m1 = 1;
        int m2 = 2;
        int res = 2;
        while (target-- > 2) {
            res = m1 + m2;
            m1 = m2;
            m2 = res;
        }
        return res;
    }

}
