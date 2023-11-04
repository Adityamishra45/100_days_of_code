public class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ov = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int ci = -1;

        for (String s : words) {
            if (s.equals("prev")) {
                if (ci == -1) {
                    ans.add(-1);
                } else {
                    ans.add(ov.get(ci--));
                }
            } else {
                int vv = 0;
                for (char c : s.toCharArray()) {
                    vv *= 10;
                    vv += (c - '0');
                }
                ci = ov.size();
                ov.add(vv);
            }
        }
        return ans;
    }
}
