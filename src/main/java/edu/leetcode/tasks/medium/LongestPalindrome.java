package edu.leetcode.tasks.medium;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String revert = revertString(s);

        return getRevertSubstring(s, revert, revert.length());
    }

    private String revertString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private String getRevertSubstring(String original, String check, int windowSize) {
        if (windowSize == original.length()) {
            return getRevertSubstring(original, check, windowSize - 1);
        }

        if (isPalindrome(check)) {
            return check;
        }
        for (int l = windowSize; l > 0; l--) {
            if (check.length() > 1) {

                for (int i = 0; i <= original.length() - l; i++) {
                    String forCheck = check.substring(i, l + i);
                    if (isPalindrome(forCheck) && original.contains(forCheck)) {
                        return forCheck;
                    }
                }
                return getRevertSubstring(original, check, l - 1);
            }
        }
        return check;
    }

    private boolean isPalindrome(String check) {
        int i = 0;
        int j = check.length() - 1;
        while (i < j) {
            if (check.charAt(i++) != check.charAt(j--)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LongestPalindrome p = new LongestPalindrome();
        System.out.println(p.longestPalindrome("asdsjjsfgh"));
        System.out.println(p.longestPalindrome("a"));
        System.out.println(p.longestPalindrome("aab"));
        System.out.println(p.longestPalindrome("ba"));
        System.out.println(p.longestPalindrome("cca"));
        System.out.println(p.longestPalindrome("aasaffzsagbbvaaeeasaaa"));
        System.out.println(p.longestPalindrome("aacabdkacaa"));
        System.out.println(p.longestPalindrome("lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc"));
    }

}
