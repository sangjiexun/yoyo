// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.coding;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import yoyo.framework.coding.Hello;
/**
 * {@link Hello} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class HelloTest {
    @Test
    public final void test() {
        assertThat(Hello.sayHello(), is("Hello"));
    }
}
