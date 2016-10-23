package Google;

import java.util.*;

/**
 * Created by Shengwei_Wang on 10/22/16.
 */
public class _425_WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new LinkedList<>();
        List<String> currentList = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words)
            trie.build(word);
        for (String word : words) {
            currentList.add(word);
            dfs(currentList, ans, trie);
            currentList.remove(0);
        }
        return ans;
    }

    void dfs(List<String> currentList, List<List<String>> ans, Trie trie) {
        if (currentList.size() == currentList.get(0).length()) {
            ans.add(new ArrayList<>(currentList));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < currentList.size(); ++i) {
                sb.append(currentList.get(i).charAt(currentList.size()));
            }
            String s = sb.toString();
            List<String> words = trie.search(s);
            for (String word : words) {
                currentList.add(word);
                dfs(currentList, ans, trie);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    class TrieNode{
        char c;
        TrieNode[] children;
        boolean isWord;
        public TrieNode (char c) {
            this.c = c;
            children = new TrieNode[26];
            isWord = false;
        }
    }

    class Trie {
        TrieNode root;
        public Trie () {
            this.root = new TrieNode('a');
        }

        public void build(String s) {
            TrieNode curr = this.root;
            for (int i = 0; i < s.length(); ++i) {
                if (curr.children[s.charAt(i) - 'a'] == null) {
                    curr.children[s.charAt(i) - 'a'] = new TrieNode(s.charAt(i));
                }
                curr = curr.children[s.charAt(i) - 'a'];
            }
            curr.isWord = true;
        }

        public List<String> search (String s) {
            TrieNode curr = root;
            List<String> ansList = new LinkedList<>();
            for (int i = 0; i < s.length(); ++i) {
                if (curr.children[s.charAt(i) - 'a'] == null)
                    return ansList;
                else
                    curr = curr.children[s.charAt(i) - 'a'];
            }

            if (curr != null)
                getWords(curr, ansList, s);
            return ansList;
        }
        void getWords(TrieNode curr, List<String> ansList, String s) {
            if (curr.isWord)
                ansList.add(s);
            for (int i = 0; i < 26; ++i)
                if (curr.children[i] != null) {
                    getWords(curr.children[i], ansList, s + (char)('a' + i));
                }
        }
    }

}
