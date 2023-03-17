class Trie {

    private final Set<String> tries = new HashSet<>();

    public Trie() {
        
    }
    
    public void insert(String word) {
        tries.add(word);
    }
    
    public boolean search(String word) {
        return tries.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        for (String aTry : tries) {
            if (aTry.startsWith(prefix))
                return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */