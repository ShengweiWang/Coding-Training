import sun.text.normalizer.Trie;

import java.util.*;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */



public class _212_WordSearchII {
    class TrieNode {
        // Initialize your data structure here.
        boolean isAWord;
        TrieNode[] next;
        public TrieNode() {
            isAWord = false;
            next = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
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
//    StringBuilder sb;
    Set<String> ans;
    Trie trie;
    char[][] board;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
//        sb = new StringBuilder();
        ans = new HashSet<>();
        trie = new Trie();
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < words.length; ++i)
            trie.insert(words[i]);
        for(int i = 0; i < board.length; ++i)
            for(int j = 0; j < board[0].length; ++j)
                dfs(i, j, "");
        Iterator<String> iterator = ans.iterator();
        List<String> res = new ArrayList<String>();
        while(iterator.hasNext()){
            res.add(iterator.next());
        }
        return res;
    }
    public void dfs(int i, int j, String word){
        word = word + board[i][j];
        if(!trie.startsWith(word))
            return;
        if(trie.search(word))
            ans.add(word);
        visited[i][j] = true;
        if(i > 0 && !visited[i-1][j]) dfs(i-1,j,word);
        if(i + 1 < board.length && !visited[i+1][j]) dfs(i+1,j,word);
        if(j > 0 && !visited[i][j-1]) dfs(i,j-1,word);
        if(j + 1 < board[0].length && !visited[i][j+1]) dfs(i,j+1,word);
        visited[i][j] = false;

    }
}
