package org.ljnpng.algorithm.hash;

public class N383CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int inx = c - 'a';
            int inx_magazine = magazine.indexOf(c, count[inx]);
            if (inx_magazine < 0) {
                return false;
            }
            count[inx] = inx_magazine + 1;
        }
        return true;
    }
}
