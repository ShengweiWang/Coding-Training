/**
 * Created by Shengwei_Wang on 9/7/16.
 */
public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        if(l == r)
            return 0;
        int ans = 0;
        while(l != r){
            int cur = Math.min(height[l], height[r]) * (r - l);
            if (cur > ans)
                ans = cur;
            if(height[l] > height[r])
                --r;
            else
                ++l;
        }
        return ans;
    }
}
