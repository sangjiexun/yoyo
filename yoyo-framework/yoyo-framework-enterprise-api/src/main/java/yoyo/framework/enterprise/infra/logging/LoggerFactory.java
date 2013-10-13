// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.logging;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
/**
 * ロガーのファクトリ
 * @author nilcy
 */
@ApplicationScoped
@SuppressWarnings("static-method")
public class LoggerFactory {
    /** 非公開コンストラクタ */
    private LoggerFactory() {
    }
    /**
     * ロガーの作成
     * @param point 注入ポイント
     * @return ロガー
     */
    @Produces
    // @Default
    private Logger createLogger(final InjectionPoint point) {
        return Logger.getLogger(point.getMember().getDeclaringClass().getName());
    }
}
