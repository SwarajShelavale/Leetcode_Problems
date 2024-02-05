class Node {
    Node[] charArray = new Node[26];
    boolean isEnd = false;

    boolean containsKey(char ch) {
        return charArray[ch - 'a'] != null;
    }

    void put(char ch, Node root) {
        charArray[ch - 'a'] = root;
    }

    Node get(char ch) {
        return charArray[ch - 'a'];
    }

    void setEnd() {
        isEnd = true;
    }

    boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private static Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch))
                return false;
            node = node.get(ch);
        }
        return true;
    }
}

