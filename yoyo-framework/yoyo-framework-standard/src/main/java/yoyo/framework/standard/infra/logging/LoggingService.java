// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.logging;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import yoyo.framework.standard.shared.Service;
/**
 * ロギングサービス
 * @author nilcy
 */
public class LoggingService implements Service {
    /** 製品番号 */
    private static final long serialVersionUID = 736359712312246979L;
    /** コンストラクタ */
    public LoggingService() {
    }
    /**
     * 無名ロガーの取得
     * <p>
     * {@link LoggingService}のロガーを返却する。
     * </p>
     * @return 無名ロガー
     */
    public static Logger getLogger() {
        return LoggerFactory.getLogger(LoggingService.class);
    }
    /**
     * ロガーの取得
     * @param clazz ロギングするクラス
     * @return ロガー
     */
    public static Logger getLogger(final Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
    /**
     * MDCの設定
     * @param map 設定値マップ
     */
    public static void putMDC(final Map<String, String> map) {
        if (map != null) {
            for (final Entry<String, String> entry : map.entrySet()) {
                MDC.put(entry.getKey(), entry.getValue());
            }
        }
    }
    /** MDCの削除 */
    public static void clearMDC() {
        MDC.clear();
    }
}
