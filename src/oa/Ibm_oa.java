package oa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/28/16.
 */
public class Ibm_oa {
    public static void main(String[] argv){
        Ibm_oa solution = new Ibm_oa();
//        System.out.println(solution.q1("20 3 4"));
        System.out.println(solution.q2("IBM cognitive computing|IBM \"cognitive\" computing is a revolution|  IBM cognitive    computing|'IBM Cognitive Computing' is a revolution?"));
    }

    public String q1(String input){
        String[] strings = input.split(" ");
        int n = Integer.valueOf(strings[0]);
        int p = Integer.valueOf(strings[1]);
        int q = Integer.valueOf(strings[2]);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; ++i){
            boolean divisible = false;
            boolean contains = false;
            if(i % p == 0 || i % q == 0)
                divisible = true;
            int cur = i;
            while(cur > 0){
                if(cur % 10 == p || cur % 10 == q){
                    contains = true;
                    break;
                }else
                    cur /= 10;
            }
            if(divisible && contains){
                sb.append("OUTTHINK").append(",");
            } else if (divisible) {
                sb.append("OUT").append(",");
            } else if (contains) {
                sb.append("THINK").append(",");
            } else {
                sb.append(Integer.toString(i)).append(",");
            }
        }
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String q2(String input){
        List<String> original = new ArrayList<>();
        List<String> filtered = new ArrayList<>();

        while(input.length() > 0){
            int i = input.indexOf("|");
            if(i != -1){
                original.add(input.substring(0, i));
                input = input.substring(i + 1);
            } else {
                original.add(input);
                input = "";
            }
            filtered.add(filter(original.get(original.size() - 1)));
        }

//        for (int i = 0; i < original.size(); ++i){
//            System.out.println(original.get(i) + " mapped to : " + filtered.get(i));
//        }

        boolean[] ignore = new boolean[original.size()];
        for(int i = 0; i < original.size(); ++i)
            for(int j = 0; j < original.size(); ++j){
                if(i == j)
                    continue;
                if(filtered.get(j).indexOf(filtered.get(i), 0) != -1){
                    if(filtered.get(i).length() == filtered.get(j).length() &&
                            original.get(i).length() < original.get(j).length()){
                        continue;
                    } else
                        ignore[i] = true;
                }
            }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < original.size(); ++i)
            if(!ignore[i]){
                sb.append(original.get(i)).append("|");
            }
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();



    }

    public String filter(String s){
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z')
                sb.append(c);
            else if (c >= 'A' && c <= 'Z')
                sb.append((char)(c - 'A' + 'a'));
            else if (c == ' '){
                if(i + 1 < s.length() && s.charAt(i + 1) != ' ')
                    sb.append(" ");
            }
        }
        return sb.toString();
    }
}

