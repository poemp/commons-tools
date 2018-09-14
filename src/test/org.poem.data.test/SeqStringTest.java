package org.poem.data.test;

import org.poem.data.string.SeqString;

public class SeqStringTest {

    public static void main(String[] args) {
        SeqString seqString = new SeqString("123".toCharArray());
        seqString.insertSeqString(seqString, 1, new SeqString("sss".toCharArray()));
    }
}
