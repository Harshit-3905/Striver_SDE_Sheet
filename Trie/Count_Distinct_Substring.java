package Trie;

import java.util.*;

//Distinct Substring is obtained by prefix of all suffix of the string
public class Count_Distinct_Substring {
    public static int countDistinctSubstrings(String s) {
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            trie.insert(suffix);
        }
        return trie.countNodes();
    }
}

class Trie {
    class TrieNode {
        TrieNode children[];
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            Arrays.fill(children, null);
            isEndOfWord = false;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

    public int countNodes() {
        return count(root);
    }

    public int count(TrieNode root) {
        int ans = 1;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null)
                ans += count(root.children[i]);
        }
        return ans;
    }

}