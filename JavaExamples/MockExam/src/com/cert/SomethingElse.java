package com.cert;
import com.exam.AccessSpecifier;
/**
 * Created by joshika on 9/5/2014.
 */
public class SomethingElse extends AccessSpecifier{
    SomethingElse(int i, float j){
        super(i, j);
        int a = 0;
        float b = 0.5f; // floating point member req postfix f
        // AccessSpecifier(a, b); can not call constructor this way
    }
}
