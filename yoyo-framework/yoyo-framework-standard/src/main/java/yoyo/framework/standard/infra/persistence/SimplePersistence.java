// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.persistence;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import yoyo.framework.standard.shared.Service;
/**
 * データ永続化の基本操作
 * @param <T> エンティティオブジェクト型
 * @author nilcy
 */
public class SimplePersistence<T extends Serializable> implements Service {
    /** 製品番号 */
    private static final long serialVersionUID = -6904142180129336340L;
    /** エンティティマネージャ */
    private final EntityManager manager;
    /** エンティティクラス */
    private final Class<T> clazz;
    /**
     * コンストラクタ
     * @param manager {@link #manager}
     * @param clazz {@link #clazz}
     */
    public SimplePersistence(final EntityManager manager, final Class<T> clazz) {
        this.manager = manager;
        this.clazz = clazz;
    }
    /**
     * 永続化
     * <dl>
     * <dt>事後条件</dt>
     * <dd>新しいエンティティを管理エンティティにする。</dd>
     * </dl>
     * @param entity 新しいエンティティ
     * @see EntityManager#persist(Object)
     */
    public void persist(final T entity) {
        manager.persist(entity);
    }
    /**
     * 同期
     * <dl>
     * <dt>事後条件</dt>
     * <dd>管理エンティティをデータベースと同期する。</dd>
     * </dl>
     * @see EntityManager#flush()
     */
    public void flush() {
        manager.flush();
    }
    /**
     * 分離
     * <dl>
     * <dt>事後条件</dt>
     * <dd>管理エンティティを分離エンティティにする。</dd>
     * </dl>
     * @param entity 管理エンティティ
     * @see EntityManager#detach(Object)
     */
    public void detach(final T entity) {
        manager.detach(entity);
    }
    /**
     * 再結合
     * <dl>
     * <dt>事後条件</dt>
     * <dd>分離エンティティを管理エンティティにする。</dd>
     * </dl>
     * @param entity 分離エンティティ
     * @return 管理エンティティ
     * @see EntityManager#merge(Object)
     */
    public T merge(final T entity) {
        return manager.merge(entity);
    }
    /**
     * 削除
     * <dl>
     * <dt>事後条件</dt>
     * <dd>管理エンティティを削除エンティティにする。</dd>
     * </dl>
     * @param entity 管理エンティティ
     * @see EntityManager#remove(Object)
     */
    public void remove(final T entity) {
        manager.remove(entity);
    }
    /**
     * 検索
     * <ul>
     * <li>エンティティを一次キーで検索する。</li>
     * </ul>
     * @param primaryKey 一次キー
     * @return 検索した管理エンティティ
     * @see EntityManager#find(Class, Object)
     */
    public T find(final Object primaryKey) {
        return manager.find(clazz, primaryKey);
    }
    /**
     * 検索
     * <ul>
     * <li>エンティティを一次キーで検索する。</li>
     * </ul>
     * @param primaryKey 一次キー
     * @param lockMode 排他モード
     * @return 検索した管理エンティティ
     * @see EntityManager#find(Class, Object, LockModeType)
     */
    public T find(final Object primaryKey, final LockModeType lockMode) {
        return manager.find(clazz, primaryKey, lockMode);
    }
    /**
     * {@link #manager} の取得
     * <ul>
     * <li>ユニットテストのコンビニ関数。</li>
     * </ul>
     * @return {@link #manager}
     */
    EntityManager getManager() {
        return manager;
    }
}
