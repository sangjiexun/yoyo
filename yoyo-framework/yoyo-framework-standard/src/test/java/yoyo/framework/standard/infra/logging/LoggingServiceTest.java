// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.logging;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.slf4j.Logger;
/**
 * {@link LoggingService}
 * @author nilcy
 */
@SuppressWarnings("all")
public class LoggingServiceTest {
    @Test
    public final void testLog() {
        final Logger testee = LoggingService.getLogger(LoggingServiceTest.class);
        testee.trace("a={}, b={}, c={}", "a01", "b01", "c01");
        testee.debug("a={}, b={}, c={}", "a01", "b01", "c01");
        testee.info("a={}, b={}, c={}", "a01", "b01", "c01");
        testee.warn("a={}, b={}, c={}", "a01", "b01", "c01");
        testee.error("a={}, b={}, c={}", "a01", "b01", "c01");
    }
    @Test
    public final void testMDC() {
        LoggingService.putMDC(null);
        final Map<String, String> map = new HashMap<>();
        map.put("account", "nilcy");
        LoggingService.putMDC(map);
        final Logger testee = LoggingService.getLogger(LoggingServiceTest.class);
        testee.trace("SET-ON MDC");
        LoggingService.clearMDC();
        testee.trace("SET-OFF MDC");
    }
}
