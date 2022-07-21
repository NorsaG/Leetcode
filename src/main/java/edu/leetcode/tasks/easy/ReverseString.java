package edu.leetcode.tasks.easy;

public class ReverseString {
    public void reverseString(char[] s) {
        for (int i=0; i< s.length/2 ;i++)
        {
            char x = s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=x;
        }
        System.out.println(s);
    }
}
