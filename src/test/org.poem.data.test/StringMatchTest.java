package org.poem.data.test;

import org.poem.data.string.StringMatch;

public class StringMatchTest {
    public static void main(String[] args) {
        String desc  = "acacacacbacbabca";
        String match = "acbab";
        int index = StringMatch.getInstance()
                .dest(desc).match(match).normalMatch();

        System.out.println("normal index:" + index + "\n\n");

        index = StringMatch.getInstance()
                .dest(desc).match(match).KMPMatch();
        System.out.println("KMP index: " + index);
    }
}
