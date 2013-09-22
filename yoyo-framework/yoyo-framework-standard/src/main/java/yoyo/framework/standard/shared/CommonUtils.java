// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.shared;
import java.io.Serializable;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.Validate;
/**
 * レイヤ共通ユーティリティ
 * @author nilcy
 */
public class CommonUtils {
    /** コンストラクタ */
    private CommonUtils() {
    }
    /**
     * 非NULLチェック
     * @param object チェック対象オブジェクト
     * @return 非NULLオブジェクト
     * @throws NullPointerException チェック対象オブジェクトがNULLのとき
     */
    public static <T> T notNull(final T object) {
        return Validate.notNull(object);
    }
    /**
     * NULLセーフ変換
     * @param object 対象オブジェクト
     * @param defaultValue NULLセーフオブジェクト
     * @param <T> 対象オブジェクト型
     * @return 対象オブジェクトがNULLのときNULLセーフオブジェクト
     * @see ObjectUtils#defaultIfNull(Object, Object)
     */
    public static <T> T nullSafe(final T object, final T defaultValue) {
        return ObjectUtils.defaultIfNull(object, defaultValue);
    }
    /**
     * シャローコピー
     * @param object コピー元オブジェクト
     * @return シャローコピーしたオブジェクト
     */
    public static <T extends Serializable> T shallowCopy(final T object) {
        return ObjectUtils.clone(object);
    }
    /**
     * ディープコピー
     * @param object コピー元オブジェクト
     * @return ディープコピーしたオブジェクト
     */
    public static <T extends Serializable> T deepCopy(final T object) {
        return SerializationUtils.clone(object);
    }
}
