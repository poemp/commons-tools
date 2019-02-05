package org.poem.utils.date.test;

import org.poem.utils.date.string.SeqString;

public class SeqStringTest {

    public static void main(String[] args) {
        SeqString seqString = new SeqString("123".toCharArray());
        seqString.insertSeqString(seqString, 1, new SeqString("sss".toCharArray()));
    }
}
