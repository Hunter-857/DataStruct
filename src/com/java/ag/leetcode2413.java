package ag;

public class leetcode2413 {

    /**
     *  啥也不是 ，哈哈
     *
     * @param n
     * @return
     */
    static public int smallestEvenMultiple(int n) {
        int min = 1;
        for (int i = 1; i <= n; i++) {
            int tmp = i * 2;
            if(tmp%2==0 && tmp %n==0){
                min = tmp;
                break;
            }

        }
        return  min ;
    }




    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(5));
        System.out.println(smallestEvenMultiple(6));
    }
}
