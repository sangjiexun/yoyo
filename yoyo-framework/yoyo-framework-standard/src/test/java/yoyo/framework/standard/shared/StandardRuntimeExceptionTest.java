// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.shared;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import yoyo.framework.standard.shared.StandardRuntimeException;
/**
 * {@link StandardRuntimeException} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class StandardRuntimeExceptionTest {
    @Test
    public final void testStandardRuntimeException() {
        assertThat(new StandardRuntimeException(), is(not(nullValue())));
    }
    @Test
    public final void testStandardRuntimeExceptionString() {
        assertThat(new StandardRuntimeException("message"), is(not(nullValue())));
    }
    @Test
    public final void testStandardRuntimeExceptionThrowable() {
        assertThat(new StandardRuntimeException(new Throwable()), is(not(nullValue())));
    }
    @Test
    public final void testStandardRuntimeExceptionStringThrowable() {
        assertThat(new StandardRuntimeException("message", new Throwable()), is(not(nullValue())));
    }
    @Test
    public final void testStandardRuntimeExceptionStringThrowableBooleanBoolean() {
        assertThat(new StandardRuntimeException("message", new Throwable(), true, true),
            is(not(nullValue())));
    }
}
