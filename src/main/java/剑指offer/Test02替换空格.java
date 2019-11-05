package 剑指offer;

public class Test02替换空格 {

    //先遍历一次统计空格数目，然后根据需要扩容的数量新建一个对象，然后执行替换操作。
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                ++count;
            }
        }
        StringBuilder builder = new StringBuilder(str.length() + count*2);
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

}
