package com.baoli.leetcode.tree;

import org.junit.Test;

/**
 * @program: common-demo
 * @description: 字典树
 * @author: li baojian
 * @create: 2020-04-23 14:32
 */
public class TrieDemo {

    @Test
    public void test() {
        //see pain pand dog
        Trie trie = new Trie();
        trie.insert("see");
        trie.insert("pain");
        trie.insert("panda");
        trie.insert("dog");
        System.out.println(trie);

    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode(' ');
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.trieNode[c - 'a'] == null) {
                    current.trieNode[c - 'a'] = new TrieNode(c);
                }
                current = current.trieNode[c - 'a'];
            }

        }

        class TrieNode {
            char c;
            TrieNode[] trieNode = new TrieNode[26];

            public TrieNode(char c) {
                this.c = c;
            }
        }
    }


}
