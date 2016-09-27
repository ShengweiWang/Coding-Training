package oa;

import java.util.*;

/**
 * Created by Shengwei_Wang on 9/26/16.
 */
public class ibm {
    public static void main(String[] argv){
        ibm solution = new ibm();
//        String input1 = "20 3 4";
//        String input2 = "7 2 3";
//        System.out.println(solution.q1(input1));
//        System.out.println(solution.q1(input2));
//
//        String q2input1 = "IBM cognitive computing|IBM \"cognitive\" computing is a revolution|  IBM cognitive    computing|'IBM Cognitive Computing' is a revolution?";
//        System.out.println(solution.q2(q2input1));
//
        String q3input1 = "Sam->Pete,Pete->Nancy,Sam->Katie,Mary->Bob,Frank->Mary,Mary->Sam,Bob->John,Sam,John";
//        System.out.println(solution.q3(q3input1));
        System.out.println(solution.q3_2(q3input1));
    }
    public String q1 (String input){
        String[] strings = input.split(" ");
        int N = Integer.valueOf(strings[0]);
        int p = Integer.valueOf(strings[1]);
        int q = Integer.valueOf(strings[2]);
        if(N < 1 || p < 1 || q < 1)
            return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N; ++i){
            sb.append(q1_cal(i, p, q)).append(",");
        }
        sb.append(q1_cal(N, p, q));
        return sb.toString();
    }
    String q1_cal (int i, int p, int q){
        boolean b1 = false;
        boolean b2 = false;
        if(i % p == 0 || i % q == 0)
            b1 = true;
        int cur = i;
        while(cur > 0){
            if(cur%10 == p || cur % 10 == q) {
                b2 = true;
                break;
            }
            cur/=10;
        }
        if(b1 && b2)
            return "OUTTHINK";
        else if (b1)
            return "OUT";
        else if (b2)
            return "THINK";
        else
            return Integer.toString(i);
    }

    public String q2(String input){
        List<String> original = new ArrayList<>();
        StringBuilder is = new StringBuilder();
        for(int i = 0; i < input.length(); ++i){
            if(input.charAt(i) != '|')
                is.append(input.charAt(i));
            else {
                original.add(is.toString());
                is.delete(0, is.length());
            }
        }
        for(int i = 0; i < original.size() ; ++i)
            System.out.print(original.get(i) + " ");


        String[] newone = new String[original.size()];
        boolean[] choose = new boolean[original.size()];
        System.out.println(original.size());
        for(int i = 0; i < original.size(); ++i){
            newone[i] = q2_compute(original.get(i));
//            System.out.println(newone[i]);
        }
        for(int i = 0; i < original.size(); ++i)
            for(int j = 0; j < original.size(); ++j){
                if(i == j)
                    continue;
                if(newone[j].indexOf(newone[i], 0) != -1){
                    if(newone[i].length() == newone[j].length() &&
                            original.get(i).length() > original.get(j).length()){
                        continue;
                    } else
                        choose[i] = true;
                }
            }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < original.size(); ++i)
            if(!choose[i]){
                sb.append(original.get(i)).append("|");
            }
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    String q2_compute(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c == ' '){
                if(sb.length() == 0 || s.charAt(i-1) == ' ')
                    continue;
                else
                    sb.append(' ');
            } else if (c >= 'a' && c <= 'z')
                sb.append(c);
            else if (c >= 'A' && c <= 'Z')
                sb.append((char)(c - 'A' + 'a'));
            else
                continue;
        }
        return sb.toString();
    }

    public class Node{
        Node parent;
        String name;
        public Node(String name){
            this.name = name;
        }
    }

    public String q3_2 (String input){
        String[] strings = input.split(",");
        Map<String, String> map = new HashMap<String, String>();
        for(int i = 0; i < strings.length - 2; ++i){
            String name1 = strings[i].substring(0, strings[i].indexOf('-'));
            String name2 = strings[i].substring(strings[i].indexOf('>') + 1);
            map.put(name2, name1);
        }
        String staff1 = strings[strings.length - 2];
        String staff2 = strings[strings.length - 1];
        int k1 = 0;
        int k2 = 0;
        String cur = staff1;
        while(cur != null){
            cur = map.getOrDefault(cur, null);
            ++k1;
        }
        cur = staff2;
        while(cur != null){
            cur = map.getOrDefault(cur, null);
            ++k2;
        }
        while(k1 > k2){
            staff1 = map.get(staff1);
            --k1;
        }
        while(k2 > k1){
            staff2 = map.get(staff2);
            --k2;
        }


        while(staff1.compareTo(staff2) != 0){
            staff1 = map.get(staff1);
            staff2 = map.get(staff2);
        }
        return staff1;

    }
    public String q3(String input){
        String[] strings = input.split(",");
        for(int i = 0; i < strings.length; ++i)
            System.out.println(strings[i]);
        Map<String, Node> map = new HashMap<String, Node>();
        for(int i = 0; i < strings.length - 2; ++i){
            String name1 = strings[i].substring(0, strings[i].indexOf('-'));
            String name2 = strings[i].substring(strings[i].indexOf('>') + 1);
            Node parent = map.getOrDefault(name1, null);
            if(parent == null){
                parent = new Node(name1);
                map.put(name1, parent);
            }

            Node child = map.getOrDefault(name2, null);
            if(child == null) {
                child = new Node(name2);
                map.put(name2, child);
            }
            child.parent = parent;
        }
        Node staff1 = map.get(strings[strings.length - 2]);
        Node staff2 = map.get(strings[strings.length - 1]);

        Node cur = staff1;
        int k1 = 0;
        int k2 = 0;
        while(cur.parent != null){
            ++k1;
            cur = cur.parent;
        }
        cur = staff2;
        while(cur.parent != null){
            ++k2;
            cur = cur.parent;
        }

        while(k1 > k2){
            staff1 = staff1.parent;
            --k1;
        }

        while(k1 < k2){
            staff2 = staff2.parent;
            --k2;
        }

        while(staff1 != staff2){
            staff1 = staff1.parent;
            staff2 = staff2.parent;
        }

        return staff1.name;

    }
}
