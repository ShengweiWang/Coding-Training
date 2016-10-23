package Google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 10/21/16.
 */
public class OA {
    public static void main(String[] argv) {
//        OA1 solution = new OA1();
//        int input1 = 223336226;
//        int input2 = 623315;
//        int input3 = 1634567;
//        System.out.println(solution.solution_identical(input1));
//        System.out.println(solution.solution_replaceWithLarger(input2));
//        System.out.println(solution.solution_roundup(input3));
//
//        OA2 solution2 = new OA2();
//        String input2_1 = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
//        System.out.println(solution2.total_path(input2_1));
//        System.out.println(solution2.total_pathToImage(input2_1));

        new_oa1 solutionnew1 = new new_oa1();
        String input_s1 = "13aw-qwe-e";
        System.out.println(solutionnew1.dash(input_s1, 3));
        System.out.println(solutionnew1.dash(input_s1, 4));
        System.out.println(solutionnew1.dash(input_s1, 5));
        System.out.println(solutionnew1.dash(input_s1, 7));
        System.out.println(solutionnew1.dash(input_s1, 8));
        System.out.println(solutionnew1.dash(input_s1, 10));
    }
}

class OA1{
    public int solution_identical(int x) {
        String s = Integer.toString(x);
        String max = "";
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                String sub = s.substring(0, i) + s.substring(i + 1);
                if (sub.compareTo(max) > 0)
                    max = sub;
            }
        }
        return Integer.valueOf(max);
    }

    public long solution_replaceWithLarger(int x) {
        String s = Integer.toString(x);
        long max = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); ++i) {
            String sub = s.substring(0, i - 1) + (char)Math.max(s.charAt(i - 1), s.charAt(i)) + s.substring(i + 1);
            max = Math.max(max, Long.valueOf(sub));
        }
        return max;
    }
    public long solution_roundup(int x) {
        String s = Integer.toString(x);
        long max = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); ++i) {
            String sub = s.substring(0, i - 1) + (char)Math.round((s.charAt(i - 1) + s.charAt(i)) / 2.0) + s.substring(i + 1);
            max = Math.max(max, Long.valueOf(sub));
        }
        return max;
    }
}

class OA2 {
    public int total_path(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Boolean> hasImage = new ArrayDeque<>();
        Set<String> imageExtention = new HashSet<>();
        imageExtention.add("gif");
        imageExtention.add("jpeg");
        imageExtention.add("png");
        int curLen = 0;
        long ansLen = 0;
        int modulo = 1000000007;
        String[] dirs = s.split("\n");
        for (String name : dirs){

            int space = 0;
            while (name.charAt(space) == ' ' && space < name.length())
                ++space;
            while (stack.size() > space) {
                curLen -= stack.pop();
                hasImage.pop();
            }
            int k = name.indexOf('.');
            if (k < 0) {
                curLen += name.length() - space + 1;
                stack.push(name.length() - space + 1);
                hasImage.push(false);
            } else {
                if (!hasImage.peek() && imageExtention.contains(name.substring(k + 1))) {
//                    System.out.println(name + curLen);
                    hasImage.pop();
                    hasImage.push(true);
                    ansLen += curLen;
                    ansLen %= modulo;
                }
            }
        }
        return (int)ansLen;

    }

    public int total_pathToImage(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> imageExtention = new HashSet<>();
        imageExtention.add("gif");
        imageExtention.add("jpeg");
        imageExtention.add("png");
        int curLen = 0;
        long ansLen = 0;
        int modulo = 1000000007;
        String[] dirs = s.split("\n");
        for (String name : dirs){

            int space = 0;
            while (name.charAt(space) == ' ' && space < name.length())
                ++space;
            while (stack.size() > space) {
                curLen -= stack.pop();
            }
            int k = name.indexOf('.');
            if (k < 0) {
                curLen += name.length() - space + 1;
                stack.push(name.length() - space + 1);
            } else {
                if (imageExtention.contains(name.substring(k + 1))) {
                    ansLen += curLen + name.length() - space + 1;
                    ansLen %= modulo;
                }
            }
        }
        return (int)ansLen;

    }
}

class new_oa1{
    public String dash(String original, int k) {
        StringBuilder sb = new StringBuilder();
        int currLen = 0;
        for (int i = original.length() - 1; i >= 0; --i){
            if (original.charAt(i) == '-')
                continue;
            if (currLen == k) {
                sb.append('-');
                currLen = 0;
            }
            ++currLen;
            sb.append(Character.toUpperCase(original.charAt(i)));
        }
        return sb.reverse().toString();
    }
}

