package oa;

/**
 * Created by Shengwei_Wang on 10/30/16.
 */
public class Twitter {
    static String decrypt(String encrypted_message) {
        int[] key = {8, 2, 5, 1, 2, 2, 0};
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = 0; i < encrypted_message.length(); ++i) {
            char c = encrypted_message.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ('a' + (c - 'a' - key [k % 7] + 26) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' - key [k % 7] + 26) % 26));
            } else {
                sb.append(c);
                --k;
            }
            ++k;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String input = "OtjfvknoukskgnlKmbxgiurtsvcnbksgqhozatvVjexcxtyqrlvtujgsmewfvvrmcxvtgrwqrjuvhmytsfelwepuqyezAtvthrqgseCnikg";
        String input1 = "Otjfvknou kskgnl K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez -Atvt hrqgse, Cnikg";
        String input2 = "Bjj rwkcs dwpyp fwz ovors wxjs vje tcez fqg";
        System.out.println(Twitter.decrypt(input2));
    }
}
