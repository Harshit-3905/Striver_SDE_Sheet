package Trie;

import java.util.*;

class Longest_String_with_All_Prefixes {
    public static String completeString(int n, String[] a) {
        Trie trie = new Trie();
        for (String x : a) {
            trie.insert(x);
        }
        trie.find();
        String ans = trie.ans;
        if (ans == "")
            return "None";
        else
            return ans;
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

    String ans;

    public String find() {
        ans = "";
        StringBuilder s = new StringBuilder();
        sol(root, s);
        return ans;
    }

    public void sol(TrieNode curr, StringBuilder s) {
        if (s.length() > ans.length())
            ans = s.toString();
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null && curr.children[i].isEndOfWord) {
                s.append((char) (i + 'a'));
                sol(curr.children[i], s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
}
