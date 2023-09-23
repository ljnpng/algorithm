package org.ljnpng.algorithm.bit;

public class N0067AddBinary {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            // 小技巧, 平常开发也可以用得上, 用来保证a >= b
            return addBinary(b, a);
        }

        int n = a.length();
        int m = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = 1;
        int sum = 0;
        while (i <= m) {
            sum += carry + a.charAt(n - i) + b.charAt(m - i) - '0' - '0';
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i++;
        }
        while (i <= n) {
            sum += carry + a.charAt(n - i) - '0';
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i++;
        }
        if (carry == 1) sb.insert(0, 1);
        return sb.toString();
    }
}
