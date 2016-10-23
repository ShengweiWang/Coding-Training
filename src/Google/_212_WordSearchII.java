package Google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 10/17/16.
 */
public class _212_WordSearchII {
    class TrieNode {
        boolean isWord;
        TrieNode[] child;
        TrieNode () {
            isWord = false;
            child = new TrieNode[26];
        }
    }
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); ++i){
                int k = s.charAt(i) - 'a';
                if (cur.child[k] == null) {
                    cur.child[k] = new TrieNode();
                }
                cur = cur.child[k];
            }
            cur.isWord = true;
        }
    }

    Trie trie;
    char[][] board;
    boolean[][] visited;
    Set<String> ans;
    int[] diri = {1, -1, 0, 0};
    int[] dirj = {0, 0, 1, -1};
    int n;
    int m;

    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        m = board[0].length;
        trie = new Trie();
        for (String word : words)
            trie.insert(word);
        this.board = board;
        visited = new boolean[n][m];
        ans = new HashSet<>();

        // System.out.println(trie.root.child[0] + " " + trie.root.child[0].isWord);
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j){
                if (trie.root.child[board[i][j] - 'a'] != null)
                    dfs(i, j, trie.root.child[board[i][j] - 'a'], "" + board[i][j]);
            }
        List<String> ansList = new ArrayList<String>();

        for (String s : ans)
            ansList.add(s);
        return ansList;
    }

    public void dfs(int i, int j, TrieNode curr, String s) {

        visited[i][j] = true;

        if (curr.isWord)
            ans.add(s);

        for (int k = 0; k < 4; ++k){
            int newi = i + diri[k];
            int newj = j + dirj[k];
            if (newi >= 0 && newi < n && newj >= 0 && newj < m &&
                    !visited[newi][newj] && curr.child[board[newi][newj] - 'a'] != null) {
                dfs(newi, newj, curr.child[board[newi][newj] - 'a'], s + board[newi][newj]);
            }
        }

        visited[i][j] = false;
    }
}

