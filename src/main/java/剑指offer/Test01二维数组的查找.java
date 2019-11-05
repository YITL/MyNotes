package 剑指offer;

public class Test01二维数组的查找 {

    //利用有序的特性
    public boolean Find(int target, int [][] array) {
        int a = 0;
        int b = array[0].length - 1;
        while(a <= array.length-1 && b >= 0){
            if(target == array[a][b]){
                return true;
            }else if(target > array[a][b]){
                a++;
            }else {
                b--;
            }
        }
        return false;
    }

}
