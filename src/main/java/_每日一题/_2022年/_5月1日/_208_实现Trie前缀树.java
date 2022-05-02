package _每日一题._2022年._5月1日;


/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _208_实现Trie前缀树 {

    /**
     * 解法1：如下
     * 解法2：内部类
     */
    class Trie {
        private boolean isEnd;
        private Trie[] childs;

        /** Initialize your data structure here. */
        public Trie() {
            isEnd = false;
            childs = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (root.childs[c - 'a'] == null) {
                    root.childs[c - 'a'] = new Trie();
                }
                root = root.childs[c - 'a'];
                if (i == word.length() - 1) {
                    root.isEnd = true;
                }
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = searchNode(word);
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return searchNode(prefix) != null;
        }

        private Trie searchNode(String prefix) {
            Trie root = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (root.childs[c - 'a'] == null) {
                    return null;
                }
                root = root.childs[c - 'a'];
            }
            return root;
        }
    }
}
