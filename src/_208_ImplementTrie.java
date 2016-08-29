/**
 * Created by Shengwei_Wang on 8/28/16.
 */

class TrieNode {
    // Initialize your data structure here.
    boolean isAWord;
    TrieNode[] next;
    public TrieNode() {
        isAWord = false;
        next = new TrieNode[26];
    }
}

public class _208_ImplementTrie {
    private TrieNode root;

    public _208_ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); ++i){
            if(cur.next[word.charAt(i) - 'a'] == null)
                cur.next[word.charAt(i) - 'a'] = new TrieNode();
            cur = cur.next[word.charAt(i) - 'a'];
        }
        cur.isAWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); ++i){
            if(cur.next[word.charAt(i) - 'a'] == null)
                return false;
            else
                cur = cur.next[word.charAt(i) - 'a'];
        }
        return cur.isAWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); ++i){
            if(cur.next[prefix.charAt(i) - 'a'] == null)
                return false;
            else
                cur = cur.next[prefix.charAt(i) - 'a'];
        }
        if(cur.isAWord)
            return true;
        for(int i = 0; i < 25; ++i){
            if(cur.next[i] != null)
                return true;
        }
        return false;
    }
}
