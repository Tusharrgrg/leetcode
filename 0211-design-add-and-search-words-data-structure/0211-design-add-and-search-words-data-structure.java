class WordDictionary {

     private final int ALPHABET_SIZE = 26;
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) node.children[ch - 'a'] = new TrieNode();
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchRecursively(root, word);
    }

    private boolean searchRecursively(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (var child : node.children)
                    if (child != null && searchRecursively(child, word.substring(i+1))) return true;
                return false;
            }
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return node != null && node.isEnd;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEnd = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */