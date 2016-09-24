/**
 * Created by Shengwei_Wang on 9/22/16.
 */
public class _135_Candy {
    public int candy(int[] ratings) {
        int[] f = new int[ratings.length];
        f[0] = 1;
        for(int i = 1; i < ratings.length; ++i)
            if(ratings[i] > ratings[i-1])
                f[i] = f[i-1] + 1;
            else
                f[i] = 1;
        for(int i = ratings.length - 2; i >=0; --i)
            if(ratings[i] > ratings[i+1])
                f[i] = Math.max(f[i], f[i+1] + 1);
        int ans = 0;
        for(int i = 0; i < ratings.length; ++i)
            ans += f[i];
        return ans;
    }
}
