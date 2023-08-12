package org.ljnpng.algorithm.hash;

public class N383CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int inx = c - 'a';
            if (count[inx] < 1) {
                return false;
            }
            count[inx]--;
        }
        return true;
    }
}
