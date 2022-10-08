package CCF;

import java.util.*;

public class ISBN3192 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] c = str.toCharArray();

        int sum = 0;
        int j = 1;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] != '-') {
                sum = sum + (c[i] - '0') * j;
                j++;
            }
        }

        int end = sum % 11;
        if (end == 10) {
            end = 'X' - '0';
        }
        if (c[c.length-1] == end + '0') {
            System.out.println("Right");
        } else {
            c[c.length-1] = (char) (end + '0');
            System.out.println(c);
        }

    }
}
