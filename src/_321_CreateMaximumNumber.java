/**
 * Created by Shengwei_Wang on 8/29/16.
 */
public class _321_CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        String f1[][] = new String [k + 1][nums1.length];
        String f2[][] = new String [k + 1][nums2.length];
        for(int i = 0; i < nums1.length; ++i)
            f1[0][i] = "";
        for(int kk = 1; kk <= k; ++kk) {
            for (int i = kk - 1; i < nums1.length; ++i) {
                if(i == 0){
                    f1[1][0] = "" + (char)(nums1[i] + '0');
                } else {
                    System.out.println(i);
//                    System.out.println(kk);
                    if(f1[kk][i-1] == null){
                        if(f1[kk-1][i-1] == null)
                            continue;
                        else
                            f1[kk][i] = f1[kk - 1][i - 1] + (char) (nums1[i] + '0');
                    } else {
                        String s2 = f1[kk - 1][i - 1] + (char) (nums1[i] + '0');
                        if (f1[kk][i - 1].compareTo(s2) > 0)
                            f1[kk][i] = f1[kk][i - 1];
                        else
                            f1[kk][i] = s2;
                    }
                }
            }
        }

//        for(int i = 0; i < k; ++i)
//            System.out.println(f1[k][nums1.length - 1]);
//        for(int kk = 1; kk <= k; ++kk) {
//            for (int i = kk; i < nums2.length; ++i) {
//                String s2 = f2[kk-1][i-1] + (char)(nums2[i] + '0');
//                if(f2[kk][i-1].compareTo(s2) >0)
//                    f2[kk][i] = f2[kk][i-1];
//                else
//                    f2[kk][i] = s2;
//            }
//        }
        return nums1;
    }
}
