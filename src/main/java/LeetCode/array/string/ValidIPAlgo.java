package LeetCode.array.string;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAlgo {

    public static void main(String[] args) {
        ValidIPAlgo v = new ValidIPAlgo();
        ArrayList<String> strings = v.validIPAddresses("1921680");
        strings.forEach(System.out::println);
    }


    List<String> res = new ArrayList<>();

    public ArrayList<String> validIPAddresses(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            if (string.length() - i < 3 || string.length() - i > 9) {
                continue;
            }
            build(3, 0, i, string, sb);
            sb.delete(0, sb.length());
        }
        return (ArrayList<String>) res;
    }

    private void build(int step, int start, int length, String string, StringBuilder sb) {
        String substring = string.substring(start, Math.min(start + length, string.length()));
        if ((substring.length() > 1 && substring.startsWith("0")) || Integer.parseInt(substring) > 255) {
            return;
        }
        if (step == 0) {
            if (substring.length() >= 1 && substring.length() <= 3) {
                sb.append(substring);
                res.add(sb.toString());
            }
            return;
        }
        sb.append(substring).append(".");
        for (int i = 1; i <= 3; i++) {
            // check if the next segment's length is legal
            if ((string.length() - start - length - i < step-1) || (string.length() - start - length - i > (step-1) * 3)) {
                continue;
            }
            build(step - 1, start + length, i, string, sb);
            sb.delete(start + length + 4 - step, sb.length());
        }
    }


}
