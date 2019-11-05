package 剑指offer;

/**
 * @author: yitl
 * @create: 2019-03-28
 */
public class Test54第一个不重复的字符 {


    /*
    自己构建了一个小型hash表
    这里注意char是八位,所以最多表示128种字符
    */
    private StringBuilder builder = new StringBuilder();
    private int[] hash = new int[128];
    public void Insert(char ch) {
        hash[ch] += 1;
        builder.append(ch);
    }
    public char FirstAppearingOnce() {
        for (int i = 0; i < builder.length(); i++) {
            if (hash[builder.charAt(i)] == 1) {
                return builder.charAt(i);
            }
        }
        return '#';
    }

}
