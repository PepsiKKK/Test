package org.example.DataStructure.ArrayAndString;

import org.example.DataStructure.ArrayAndString.TestString;
import org.junit.Test;

public class TestStringTest {
    String str = "abacd";
    String str2 = "7712332166";
    String[] strs = {"flower","flow","flight"};

    @Test
    public void longestPalindrome() {
        System.out.println(TestString.longestPalindrome(str));
        System.out.println(TestString.longestPalindrome(str2));
    }

    @Test
    public void longestCommonPrefix() {
        System.out.println(TestString.longestCommonPrefix(strs));
    }

    @Test
    public void reverseWords() {
        System.out.println(TestString.reverseWords("  this is a word          "));
    }
}