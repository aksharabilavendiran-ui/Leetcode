class Solution {
    public String countAndSay(int n) {
        String result = "1"; // first term
        for (int i = 1; i < n; i++) {
            result = buildNext(result);
        }
        return result;
    }

    private String buildNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        return sb.toString();
    }
}
