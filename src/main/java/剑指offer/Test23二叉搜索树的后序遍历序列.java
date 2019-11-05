package 剑指offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * @author: yitl
 * @create: 2019-03-14
 */
public class Test23二叉搜索树的后序遍历序列 {

    /**
     * 运用二叉搜索树的性质，根节点的左子树所有值都比根节点小，右子树所有值都比根节点大。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length-1);
    }

    public boolean verify(int[] seq, int start, int end) {
        if (start >= end) return true;
        int i = end-1;
        while (i >= 0 && seq[i] > seq[end]){
            --i;
        }
        int m = i;
        while (i >= 0) {
            if (seq[i] > seq[end]) {
                return false;
            }
            --i;
        }
        return verify(seq, start, m) && verify(seq, m+1, end-1);
    }

}
