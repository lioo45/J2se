package interview;

/**
 * Created by pro on 17/4/16.
 */
public class P68_9_3 {
    public static void main(String[] args) {
        int a[] = {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        };
        System.out.println(findMagicIndex(a, a.length));
    }

    public static boolean findMagicIndex(int[] A, int n) {
        // write code here
        if (A == null || A.length <= 0 || n <= 0)
            return false;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] == mid) {
                return true;
            } else if (A[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean findMagicIndex2(int[] A, int n) {
        // write code here
        if (A == null || A.length <= 0 || n <= 0)
            return false;
        return help(A,0,A.length-1);
    }

    static boolean help(int[] a,int left,int right){
        if(left>right)
            return false;
        boolean leftOk=false;
        boolean rightOk=false;
        int mid=(left+right)/2;
        if(a[mid]==mid)
            return true;
        leftOk=help(a,left,mid-1);
        rightOk=help(a,mid+1,right);
        if(leftOk||rightOk)
            return true;
        return false;
    }

}
