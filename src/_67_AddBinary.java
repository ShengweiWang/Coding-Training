/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _67_AddBinary {
    public String addBinary(String a, String b) {
        int la = a.length() - 1;
        int lb = b.length() - 1;
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        while(la >=0 && lb >=0){
            cur += ((int)a.charAt(la) - '0' + (int)b.charAt(lb) - '0');
            sb.append(cur & 1);
            cur >>=1;
            --la;
            --lb;
        }
        while(la >= 0){
            cur += ((int)a.charAt(la) - '0');
            sb.append(cur & 1);
            cur >>=1;
            --la;
        }
        while(lb >= 0){
            cur += ((int)b.charAt(lb) - '0');
            sb.append(cur & 1);
            cur >>=1;
            --lb;
        }
        if(cur != 0){
            sb.append(1);
        }
        sb.reverse();
        return sb.toString();
    }
}
