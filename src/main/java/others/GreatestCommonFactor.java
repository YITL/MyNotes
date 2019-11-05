package others;

public class GreatestCommonFactor {

    public static void main(String[] args) {
        int i = greatestCommonFactor(123456, 7890);
        System.out.println(i);
    }

    public static int greatestCommonFactor(int m, int n){
        int left = Math.max(m, n);
        int right = Math.min(m, n);
        int res = left % right;
        while (res != 0) {
            left = right;
            right = res;
            res = left % right;
        }
        return right;
    }

}
