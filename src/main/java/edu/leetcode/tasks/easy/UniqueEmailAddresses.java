package edu.leetcode.tasks.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String validEmail = getValidEmail(email);
            if (validEmail != null)
                emailSet.add(validEmail);
        }
        return emailSet.size();
    }

    private String getValidEmail(String email) {
        if (!email.endsWith(".com")) {
            return null;
        }

        if (email.startsWith("+")) {
            return null;
        }

        String[] split = email.split("@");
        String localName = split[0];
        String domainName = split[1];

        localName = localName.replace(".", "");
        int plusIndex = localName.indexOf("+");

        if (plusIndex != -1) {
            localName = localName.substring(0, plusIndex);
        }
        return localName + "@" + domainName;
    }

    public static void main(String[] args) {
        UniqueEmailAddresses m = new UniqueEmailAddresses();
        System.out.println(m.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
