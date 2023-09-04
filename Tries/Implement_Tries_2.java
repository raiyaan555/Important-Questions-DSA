package Tries;

import java.util.*;
import java.io.*;

public class Implement_Tries_2 {

    class Node {
        Node links[] = new Node[26];
        int countEndWith = 0;
        int countPrefix = 0;

        boolean containsKey(char c) {
            return (links[c - 'a'] != null);
        }

        Node get(char c) {
            return links[c - 'a'];
        }

        void put(char c, Node node) {
            links[c - 'a'] = node;
        }

        void increaseEnd() {
            countEndWith++;
        }

        void decreaseEnd() {
            countEndWith--;
        }

        void increasePrefix() {
            countPrefix++;
        }

        void decreasePrefix() {
            countPrefix--;
        }

        int getEnd() {
            return countEndWith;
        }

        int getPrefix() {
            return countPrefix;
        }
    }

    public class Trie {
        Node root;

        public Trie() {
            root = new Node();

        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i))) {
                    node.put(word.charAt(i), new Node());
                }
                node = node.get(word.charAt(i));
                node.increasePrefix();
            }
            node.increaseEnd();
        }

        public int countWordsEqualTo(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.get(word.charAt(i));
                } else {
                    return 0;
                }
            }
            return node.getEnd();
        }

        public int countWordsStartingWith(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.get(word.charAt(i));
                } else {
                    return 0;
                }
            }
            return node.getPrefix();
        }

        public void erase(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.get(word.charAt(i));
                    node.decreasePrefix();
                } else {
                    return;
                }
                node.decreaseEnd();
            }
        }

    }

}