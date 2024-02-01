package Trie;

import java.util.*;

class Implement_Trie {
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

    public Implement_Trie() {
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

    public boolean search(String word) {
        TrieNode curr = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return true;
    }
}