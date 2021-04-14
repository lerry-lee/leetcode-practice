package _每日一题._2021年._21年4月;

import java.util.HashMap;

/**
 * @ClassName: _208实现Trie前缀树
 * @Author: lerry_li
 * @CreateDate: 2021/04/14
 * @Description
 * 解法1：hash表
 * 解法2：计数数组
 */
public class _208实现Trie前缀树 {

    public static void main(String[] args) {
        _208实现Trie前缀树 instance = new _208实现Trie前缀树();
        Trie trie = instance.new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }

    class TrieNode {
        public boolean isEnd;
        public HashMap<Character, TrieNode> children;


        public TrieNode() {
            isEnd = false;
            children = new HashMap<>();
        }
    }

    class Trie {
        private TrieNode trieNode;

        /** Initialize your data structure here. */
        public Trie() {
            trieNode = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = trieNode;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
                if (i == word.length() - 1) {
                    cur.isEnd = true;
                }
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchNode(word);
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchNode(prefix) != null;
        }

        private TrieNode searchNode(String prefix) {
            TrieNode cur = trieNode;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!cur.children.containsKey(c)) {
                    return null;
                }
                cur = cur.children.get(c);
            }
            return cur;
        }
    }
}
