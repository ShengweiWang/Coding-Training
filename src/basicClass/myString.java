package basicClass;

/**
 * Created by Shengwei_Wang on 9/29/16.
 */
public class myString {
    String s;
    public myString(){
        s = "";
    }
    public myString(char[] c){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c.length; ++i)
            sb.append(c[i]);
        s = sb.toString();

    }

    String trim(){
        int i = 0;
        int j = s.length() - 1;
        while(i <= j && s.charAt(i) == ' ')
            ++i;
        while(i <= j && s.charAt(j) == ' ')
            --j;
        return s.substring(i, j + 1);
    }

    String compressWS(){  //compress extra whitespace
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            if(s.charAt(i) == ' ' && i < s.length() - 1 && s.charAt(i + 1) == ' ')
                continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    String ignoreC() {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        boolean space = false;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                if (space)
                    sb.append(' ');
                space = false;
                sb.append(c);
            }
            else if (c >= 'A' && c <= 'Z'){
                if (space)
                    sb.append(' ');
                space = false;
                sb.append(c);
            }
            else if (c == ' ')
                space = true;
            ++i;
        }
        return sb.toString();
    }

    void set(String s){
        this.s = s;
    }
}
