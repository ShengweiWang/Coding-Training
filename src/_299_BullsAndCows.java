/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _299_BullsAndCows {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] se = new int[256];
        int[] gu = new int[256];
        for(int i = 0; i < secret.length(); ++i){
            if(secret.charAt(i) == guess.charAt(i))
                ++a;
            else {
                ++se[secret.charAt(i)];
                ++gu[guess.charAt(i)];
            }
        }
        for(int i = '0'; i <='9'; ++i){
            b += Math.min(se[i], gu[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append('A');
        sb.append(b);
        sb.append('B');
        return sb.toString();
    }
}
