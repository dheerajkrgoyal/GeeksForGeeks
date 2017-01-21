import java.util.HashMap;
import java.util.Map;


/**
 * Implementation of Trie in Java
 * Created by dheeraj on 21/1/17.
 */
public class Trie
{
    private class TrieNode{
        char ch;
        TrieNode[] children = new TrieNode[26];
        boolean isFullWord;

        public TrieNode(char c){
            this.ch = c;
        }

        public TrieNode(){}
    }

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode[] children = root.children;

        for(int i=0;i<word.length();i++){
            TrieNode t;
            char c = word.charAt( i );
            int index = c - 'a';
            if(children[index] != null){
                t = children[index];
            }
            else{
                t= new TrieNode(c);
                children[index] = t;
            }

            children = t.children;

            if(i == word.length()-1){
                t.isFullWord = true;
            }
        }
    }

    public boolean searchWord(String word){
        TrieNode[] children = root.children;

        for(int i=0; i<word.length();i++){
            TrieNode t;
            char c = word.charAt( i );
            int index = c - 'a';
            if(children[index] != null){
                t= children[index];
                children = t.children;
            }
            else{
                return false;
            }
            if(i==word.length()-1 && t.isFullWord){
                return true;
            }
        }
        return true;
    }

    public boolean hasWordWithPrefix(String prefix){
        TrieNode[] children = root.children;
        for(int i=0; i<prefix.length();i++){
            TrieNode t;
            char c = prefix.charAt( i );
            int index = c -'a';
            if(children[index] != null){
                t = children[index];
                children = t.children;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public int countPrefixedWord(String prefix){
        TrieNode[] children = root.children;
        TrieNode t = null;
        for(int i = 0 ; i< prefix.length(); i ++){
            char c = prefix.charAt( i );
            int index = c -'a';
            if(children[index] != null){
                t= children[index];
                children = t.children;
            }
            else{
                return 0;
            }
        }

        return countWord(t);

    }

    private int countWord(TrieNode t){
        int count = 0;
        if(t.isFullWord){
            count += 1;
        }
        if(t.children != null){
            for(int i = 0; i< t.children.length ; i++){
                TrieNode temp = t.children[i];
                if(temp != null) {
                    count += countWord( temp );
                }
            }
        }

        return count;

    }


    public static void main( String[] args )
    {
        Trie trie = new Trie();
        trie.insert( "hack" );
        trie.insert( "hackerrank" );
        System.out.println(trie.countPrefixedWord( "hac" ));
        System.out.println(trie.countPrefixedWord( "hak" ));
    }

}
