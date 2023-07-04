package Strings;

public class P15_Zig_Zag_Conversion {
    public String convert(String s, int numRows) {

        int n = s.length();
        if (numRows == 1)
            return s;

        StringBuilder[] arr = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder("");
        }

        boolean flag = false;
        int c = 0;

        for (int i = 0; i < n; i++) {
            arr[c].append(s.charAt(i));
            if (c == 0 || c == numRows - 1) {
                flag = !flag;
            }
            if (flag)
                c++;
            else
                c--;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(arr[i]);
        }

        return res.toString();
    }
}
