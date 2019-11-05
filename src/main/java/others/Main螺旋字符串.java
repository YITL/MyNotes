package others;


import java.util.Scanner;

public class Main螺旋字符串 {
    /*
    螺旋字符串
    测试用例:
    输入:test:n@hbxDgWg/s"ho&g!^)|XLAW0|>ytNLVOHmP>2*\IO6XvX6OI\*2>PmHOVLNty>|0WALX|)^!g&oh"s/gWgDxbh@n@hbxDgWg/s"ho&g!^)|XLAW0|>ytNLVOHmP>2*\IO6Xv
    输出:n@hbxDgWg/s"ho&g!^)|XLAW0|>ytNLVOHmP>2*\IO6XvX6OI\*2>PmHOVLNty>|0WALX|)^!g&oh"s/gWgDxbh@n@hbxDgWg/s"ho&g!^)|XLAW0|>ytNLVOHmP>2*\IO6Xv
    */

    /*
    2.注意：完成代码后，在此填写时间复杂度：O(n²)
    */
    public static String findLongestScrewString(String str){
        if (str == null || str.isEmpty()) return "";
        if (str.length() == 1 || str.length() == 2 || str.length() == 3) return "";
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            String tmp = findLongestScrewString(i, str);
            res = res.length() >= tmp.length() ? res : tmp;
        }
        return res;
    }

    private static String findLongestScrewString(int index, String str){
        int m = index;
        char[] arr = new char[str.length()];
        int arrIndex = 0;
        arr[arrIndex++] = str.charAt(index++);
        for (; index < str.length()-1; index++) {
            if (str.charAt(index+1) != str.charAt(index-1)) {
                arr[arrIndex++] = str.charAt(index);
            } else {
                arr[arrIndex] = str.charAt(index);
                break;
            }
        }
        boolean flag = true;
        boolean derection = true;//true为逆向,false为正向
        int count = 0;
        while (flag && index < str.length()) {
            if (index >= str.length()-1) {
                flag = false;
                break;
            }
            count++;
            if (derection) {
                derection = false;
                for (int i = arrIndex; i > 0; i--) {
                    if (str.charAt(index+1) != arr[arrIndex-1]) {
                        if (str.charAt(index+1) != arr[arrIndex+1]) {
                            flag = false;
                        }
                        break;
                    }
                }
            } else {
                derection = true;
                for (int i = arrIndex; i < arr.length-1; i++) {
                    if (str.charAt(index+1) != arr[arrIndex+1]) {
                        if (str.charAt(index+1) != arr[arrIndex-1]) {
                            flag = false;
                        }
                        break;
                    }
                }
            }
        }
        if (count >2) {
            return str.substring(m, index+1);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while (in.hasNext()){
            String inStr = in.next();
            System.out.println(findLongestScrewString(inStr));
        }
    }


}
