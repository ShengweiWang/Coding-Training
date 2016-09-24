/**
 * Created by Shengwei_Wang on 9/23/16.
 */
public class _10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean [] rec = new boolean[pp.length];
        boolean [][] f = new boolean[ss.length][pp.length];
        int size = 0;
        for(int i = 0; i < pp.length; ++i){
            if(pp[i] != '*'){
                pp[size] = pp[i];
                ++size;
            } else {
                rec[size - 1] = true;
            }
        }

        if(ss.length == 0){
            for(int i = 0; i < size; ++i)
                if(!rec[i])
                    return false;
            return true;
        }
        if(pp.length == 0)
            return false;
        boolean still = true;
        for(int j = 0; j < size; ++j) {
            if(still && (pp[j] == '.' || pp[j] == ss[0]))
                f[0][j] = true;
            if(!rec[j])
                still = false;
            if(rec[j] && j > 0)
                f[0][j] = f[0][j] || f[0][j-1];
        }
        for(int i = 1; i < ss.length; ++i){
            f[i][0] = f[i-1][0] && rec[0] && (ss[i] == pp[0] || pp[0] == '.');
            for(int j = 1; j < size; ++j){
                if(ss[i] == pp[j] || pp[j] == '.')
                    f[i][j] = f[i-1][j-1];
                if(rec[j]) {
                    if(ss[i] == pp[j] || pp[j] == '.')
                        f[i][j] = (f[i][j - 1] || f[i-1][j] || f[i-1][j-1]);
                    else
                        f[i][j] = f[i][j-1];
                }
            }
        }

        // for(int i = 0 ; i < ss.length; ++i){
        //     for(int j = 0; j < size; ++j)
        //         System.out.print(f[i][j] + " ");
        //     System.out.println();
        // }
        return f[ss.length-1][size - 1];
    }
}
