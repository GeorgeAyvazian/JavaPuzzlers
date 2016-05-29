package google;

import java.util.HashSet;
import java.util.Set;

public class AccessCodes {
    public static void main(String[] args) {
        String[] x = {"foo", "bar", "oof", "bar"};
//        String[] x = {"x", "y", "xy", "yy", "", "yx"};
        System.out.println(answer(x));
    }

    private static int answer(String[] x) {
        class String1 {
            private final String string;
            private String reversed;

            private String1(String string) {
                this.string = string;
                reversed = string;
                if (string.length() > 1) {
                    reversed = "";
                    char[] chars = string.toCharArray();
                    reversed = "";
                    for (int j = chars.length - 1; j >= 0; j--) {
                        reversed += chars[j];
                    }
                }
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                String1 string1 = (String1) o;

                if (string.equals(string1.string)) return true;
                if (string.equals(string1.reversed)) return true;
                if (reversed.equals(string1.string)) return true;
                return reversed.equals(string1.reversed);

            }

            @Override
            public int hashCode() {
                return string.hashCode() + reversed.hashCode();
            }
        }

        Set<String1> codes = new HashSet<>(x.length);
        for (String s : x) {
            codes.add(new String1(s));
        }
        return codes.size();
    }


}
