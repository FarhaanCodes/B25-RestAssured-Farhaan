package com.cydeo.day5;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

    @DisplayName("Assertion witn Numbers")
    @Test
    public void test1(){


        assertThat(5+5,is(10));
        assertThat(5+5,equalTo(10));

        //matchers has 2 overloaded version
        //first that accept actual value
        //second that accept another matchers
        assertThat(5+5,is(equalTo(10)));

        assertThat(5+5,not(9));
        assertThat(5+5,is(not(9)));
        assertThat(5+5,is(not(equalTo(8))));

        //greaterThan()
        //greaterThanOrEqualTo()
        //lessThan()
        //lessThanOrEqualTo()
        assertThat(5+5,is(greaterThan(9)));
    }

    @DisplayName("Assertion with String")
    @Test
    public void test2(){

        String text = "B25 is learning Hamcrest";

        //checking for equality

        assertThat(text, is("B25 is learning Hamcrest"));
        assertThat(text, equalTo("B25 is learning Hamcrest"));
        assertThat(text, is(equalTo("B25 is learning Hamcrest")));

        //check if this text starts with B25
        assertThat(text, startsWith("B25"));

        // case insensitive
        assertThat(text, startsWithIgnoringCase("b25"));

        //ends with
        assertThat(text, endsWith("Hamcrest"));

        // check if tet contains String learning

        assertThat(text, containsString("learning"));

        //with ignoring case
        assertThat(text, containsStringIgnoringCase("Learning"));

        String str = " ";


        //check if str is blank

        assertThat(str, blankString());

        //check if trimmer str is empty string
        assertThat(str.trim() , emptyString());

    }
}
