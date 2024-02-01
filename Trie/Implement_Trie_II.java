package Trie;

import java.util.*;

public class Implement_Trie_II {
    class TrieNode {
        TrieNode children[];
        int endOfWord;

        TrieNode() {
            children = new TrieNode[26];
            Arrays.fill(children, null);
            endOfWord = 0;
        }
    }

    TrieNode root;

    public Implement_Trie_II() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        int l = word.length();
        for (int i = 0; i < l; i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.endOfWord += 1;
    }

    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        int l = word.length();
        for (int i = 0; i < l; i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null)
                return 0;
            curr = curr.children[index];
        }
        return curr.endOfWord;
    }

    public int countWordsStartingWith(String word) {
        TrieNode curr = root;
        int l = word.length();
        for (int i = 0; i < l; i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null)
                return 0;
            curr = curr.children[index];
        }
        return count(curr);
    }

    public int count(TrieNode curr) {
        int ans = curr.endOfWord;
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null)
                ans += count(curr.children[i]);
        }
        return ans;
    }

    public void erase(String word) {
        TrieNode curr = root;
        int l = word.length();
        for (int i = 0; i < l; i++) {
            int index = word.charAt(i) - 'a';
            curr = curr.children[index];
        }
        curr.endOfWord -= 1;
    }

}
