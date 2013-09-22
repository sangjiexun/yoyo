// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.shared;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
import yoyo.framework.standard.shared.StandardException;
/**
 * {@link StandardException} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class StandardExceptionTest {
    @Test
    public void testStandardExceptionStringObjectArray() {
        assertThat(new StandardException("key"), is(not(nullValue())));
        assertThat(new StandardException("key", "foo", "bar", "baz"), is(not(nullValue())));
    }
    @Test
    public void testStandardExceptionMapOfStringObject() {
        final Map<String, Object[]> causeMap = new LinkedHashMap<>();
        assertThat(new StandardException(causeMap), is(not(nullValue())));
    }
    @Test
    public void testGetCauseMap() {
        final Map<String, Object[]> causeMap = new LinkedHashMap<>();
        final StandardException testee = new StandardException("key");
        assertThat(testee.getCauseMap(), is(not(nullValue())));
    }
}
