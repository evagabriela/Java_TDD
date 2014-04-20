import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.junit.internal.matchers.StringContains.containsString;
import static org.junit.matchers.JUnitMatchers.both;

/**
 * Created by evazamudio on 2014-04-20.
 */
public class StringJoinerTest {
    private ArrayList<String> strings;
    private StringJoiner joiner;
    @Before
    public void setUp() throws Exception{
        strings = new ArrayList<String>();
        joiner = new StringJoiner("SomeStringHere");
    }

    @Test
    public void shouldJoinEmptyStringsWhenListIsEmpty() {
        assertThat(joiner.join(strings), is(""));
    }
    @Test
    public void shouldJoinStringWhenListIsOneReturnString(){
        String aString = "one";
        strings.add(aString);
        assertThat(joiner.join(strings), is(aString));
    }

    @Test
    public void shouldContainBothStringsWhenListIsTwoStrings(){
        strings.add("A");
        strings.add("B");
        assertThat(joiner.join(strings),
                both(containsString("A")).
                and(containsString("B")));
    }

    @Test
    public void shouldPutDelimiterBetweenStrings(){
        StringJoiner joinerWithDelimiter = new StringJoiner(",");
        strings.add("A");
        strings.add("B");
        assertThat(joinerWithDelimiter.join(strings), is("A,B"));
    }
}

