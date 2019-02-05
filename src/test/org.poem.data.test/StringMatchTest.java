package org.poem.utils.date.test;

import org.poem.utils.date.string.StringMatch;
import org.poem.lang.exception.ParameterException;

public class StringMatchTest {
    public static void main(String[] args) {
        String desc  = "acacacacacacacacacbacbabca";
        String match = "acbab";
        System.out.println(desc + "\t\t\t\t\t\t\t\t\n" + match);
        int index = StringMatch.getInstance()
                .dest(desc).match(match).normalMatch();

        System.out.println("normal index:" + index + "\n\n");

        try {
            index = StringMatch.getInstance()
                    .dest(desc).match(match).KMPMatch();
        } catch (ParameterException e) {
            e.printStackTrace();
        }
        System.out.println("KMP index: " + index);
    }
}
