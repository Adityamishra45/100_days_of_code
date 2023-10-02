class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26]; // Assuming only lowercase letters

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        boolean[] inStack = new boolean[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (inStack[c - 'a']) {
                continue;
            }

            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                inStack[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(c);
            inStack[c - 'a'] = true;
        }

        return sb.toString();
    }
}
