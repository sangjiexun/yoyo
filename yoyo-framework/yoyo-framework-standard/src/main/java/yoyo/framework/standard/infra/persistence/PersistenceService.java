// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.persistence;
import java.io.Serializable;
import javax.persistence.EntityManager;
import yoyo.framework.standard.shared.Service;
/**
 * データ永続化サービス
 * @param <T> エンティティオブジェクト型
 * @author nilcy
 */
public class PersistenceService<T extends Serializable> implements Service {
    /** 製品番号 */
    private static final long serialVersionUID = -2090016097142789454L;
    /** エンティティマネージャ */
    private EntityManager manager;
    /** 基本データ永続化 */
    private SimplePersistence<T> simplePersistence;
    /** コンストラクタ */
    public PersistenceService() {
    }
    /**
     * コンストラクタ
     * @param manager {@link #manager}
     * @param clazz エンティティクラス
     */
    public PersistenceService(final EntityManager manager, final Class<T> clazz) {
        this.manager = manager;
        simplePersistence = new SimplePersistence<>(manager, clazz);
    }
    /**
     * {@link #manager} の取得
     * @return {@link #manager}
     */
    public EntityManager getManager() {
        return manager;
    }
    /**
     * {@link #simplePersistence} の取得
     * @return {@link #simplePersistence}
     */
    public SimplePersistence<T> getBasicPersistence() {
        return simplePersistence;
    }
}
