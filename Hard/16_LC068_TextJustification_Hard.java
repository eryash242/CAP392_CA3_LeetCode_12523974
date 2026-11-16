import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i + 1;
            int length = words[i].length();

            while (j < words.length &&
                   length + words[j].length() + (j - i) <= maxWidth) {
                length += words[j].length();
                j++;
            }

            int spaces = maxWidth - length;
            int count = j - i;
            StringBuilder line = new StringBuilder();

            if (j == words.length || count == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }
            else {
                int spaceBetween = spaces / (count - 1);
                int extraSpaces = spaces % (count - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int space = spaceBetween;

                        if (extraSpaces > 0) {
                            space++;
                            extraSpaces--;
                        }

                        for (int m = 0; m < space; m++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
