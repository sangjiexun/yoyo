// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.logging;
import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
/**
 * {@link LoggingService}
 * @author nilcy
 */
@SuppressWarnings("all")
public class LoggingServiceTest {
    private final LoggingService testee = new LoggingService();
    @Test
    public final void testGetLogger() {
        final Logger logger = LoggingService.getLogger(LoggingServiceTest.class);
        logger.trace("a={}, b={}, c={}", "a01", "b01", "c01");
    }
    @Test
    public final void testPutMDC() {
        fail("Not yet implemented"); // TODO
    }
    @Test
    public final void testClearMDC() {
        fail("Not yet implemented"); // TODO
    }
}
