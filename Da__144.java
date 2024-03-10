class Solution {
    String removeDuplicates(String str) {
        StringBuilder n = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (n.length() == 0) {
                n.append(str.charAt(i));
            } else if (n.toString().contains(String.valueOf(str.charAt(i)))) {
                continue;
            } else if (n.charAt(n.length() - 1) != str.charAt(i)) {
                n.append(str.charAt(i));
            }
        }
        return n.toString();
    }
}
