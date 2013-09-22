// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import yoyo.framework.standard.domain.NotSpecification;
/**
 * {@link yoyo.framework.standard.domain.NotSpecification} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class NotSpecificationTest {
    private final TrueSpecification trueSpec = new TrueSpecification();
    private final FalseSpecification falseSpec = new FalseSpecification();
    @Test
    public final void testIsSatisfiedBy() {
        assertThat(new NotSpecification<Object>(trueSpec).isSatisfiedBy(new Object()), is(false));
        assertThat(new NotSpecification<Object>(falseSpec).isSatisfiedBy(new Object()), is(true));
    }
}
