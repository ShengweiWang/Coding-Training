package oa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/28/16.
 */
public class ibm_realOA {
    public static void main(String[] argv){
        ibm_realOA solution = new ibm_realOA();
//        System.out.println(solution.q1("20 3 4"));
        solution.q2("IBM cognitive computing|IBM \"cognitive\" computing is a revolution|  IBM cognitive    computing|'IBM Cognitive Computing' is a revolution?");
    }

    public void q2(String s){
    List<String> original = new ArrayList<String>();
    List<String> filtered = new ArrayList<String>();

    while(s.length() > 0){
        int i = s.indexOf("|");
        if(i != -1) {
            original.add(s.substring(0, i));
            s = s.substring(i + 1);
        } else {
            original.add(s);
            s = "";
        }
        filtered.add(filter(original.get(original.size() - 1)));
    }



    int n = original.size();

        for(int i = 0; i < n; ++i)
            System.out.println(original.get(i) + " mapped to : " + filtered.get(i));

    boolean[] ignored = new boolean[n];
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            if(i == j){
                continue;
            } else {
                if(filtered.get(j).indexOf(filtered.get(i), 0) != -1){
                    if(filtered.get(j).length() == filtered.get(i).length()
                            && original.get(i).length() < original.get(j).length())
                        continue;
                } else {
                    ignored[i] = true;
                    break;
                }
            }
        }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; ++i){
        if(!ignored[i]) {
            sb.append(original.get(i)).append("|");
        }
    }

    if(sb.length() > 0)
            sb.deleteCharAt(sb.length() -1);
    System.out.println(sb.toString());

}

    static String filter(String s){
        StringBuilder sb = new StringBuilder();
        s = s.trim(); //discard leading and trailing whitespace

        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char)(c - 'A' + 'a'));
            } else if (c == ' ') {
                if(s.charAt(i + 1) == ' '){
                    continue;
                } else {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

}
