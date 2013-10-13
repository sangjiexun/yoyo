// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.logging;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import yoyo.framework.standard.shared.MessageUtils;
/**
 * トレースロガーのインターセプタ
 * @author nilcy
 */
@Interceptor
@TraceLogger
public class TraceLoggerInterceptor {
    /**
     * トレースログの出力
     * @param aContext コンテキスト
     * @return 処理結果
     * @throws Exception 処理例外
     */
    @SuppressWarnings("static-method")
    @AroundInvoke
    public Object traceLog(final InvocationContext aContext) throws Exception {
        final Logger log = Logger.getLogger(aContext.getMethod().getDeclaringClass().toString());
        final String methodName = aContext.getMethod().getName();
        log.info(MessageUtils.build("Entering #{0} with {1}.", methodName, aContext.getParameters()));
        try {
            final Object result = aContext.proceed();
            log.info(MessageUtils.build("Exiting #{} with {}.", methodName, result));
            return result;
        } catch (final Exception e) {
            // OK to catch Exception here
            log.warning(e.getLocalizedMessage());
            throw e;
        }
    }
}
