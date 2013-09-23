// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.persistence;
import java.io.Serializable;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.LockTimeoutException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.TransactionRequiredException;
import org.slf4j.Logger;
import yoyo.framework.standard.infra.logging.LoggingService;
import yoyo.framework.standard.shared.Service;
/**
 * データ永続化の基本操作
 * @param <T> エンティティオブジェクト型
 * @author nilcy
 */
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
    /** ロガー */
    private static final Logger LOG = LoggingService.getLogger(SimplePersistence.class);
    /**
     * コンストラクタ
     * <dl>
     * <dt>事前条件</dt>
     * <dd>パラメータがNULLでないこと。</dd>
     * <dt>事後条件</dt>
     * <dd>パラメータがインスタンス変数に設定されること。</dd>
     * </dl>
     * @param manager {@link #manager}
     * @param clazz {@link #clazz}
     */
    public SimplePersistence(final EntityManager manager, final Class<T> clazz) {
        assert (manager != null) && (clazz != null);
        this.manager = manager;
        this.clazz = clazz;
    }
    /**
     * 永続化
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>新しいエンティティを管理エンティティにすること。</dd>
     * </dl>
     * @param entity 新しいエンティティ
     * @throws EntityExistsException 登録済のエンティティがあるとき
     * @throws IllegalArgumentException エンティティでないとき
     * @throws TransactionRequiredException トランザクションを開始していないとき
     * @see EntityManager#persist(Object)
     */
    public void persist(final T entity) {
        try {
            manager.persist(entity);
        } catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /**
     * 同期
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>管理エンティティをデータベースと同期すること。</dd>
     * </dl>
     * @throws TransactionRequiredException トランザクションを開始していないとき
     * @throws PersistenceException データベースの同期が失敗したとき
     * @see EntityManager#flush()
     */
    public void flush() {
        try {
            manager.flush();
        } catch (final PersistenceException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /**
     * 分離
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>管理エンティティを分離エンティティにすること。</dd>
     * </dl>
     * @param entity 管理エンティティ
     * @throws IllegalArgumentException エンティティでないとき
     * @see EntityManager#detach(Object)
     */
    public void detach(final T entity) {
        try {
            manager.detach(entity);
        } catch (final IllegalArgumentException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /**
     * 再結合
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>分離エンティティを管理エンティティにすること。</dd>
     * </dl>
     * @param entity 分離エンティティ
     * @return 管理エンティティ
     * @throws IllegalArgumentException エンティティでないとき
     * @throws TransactionRequiredException トランザクションを開始していないとき
     * @see EntityManager#merge(Object)
     */
    public T merge(final T entity) {
        try {
            return manager.merge(entity);
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /**
     * 削除
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>管理エンティティを削除エンティティにすること。</dd>
     * </dl>
     * @param entity 管理エンティティ
     * @throws IllegalArgumentException エンティティでない、または分離エンティティのとき
     * @throws TransactionRequiredException トランザクションを開始していないとき
     * @see EntityManager#remove(Object)
     */
    public void remove(final T entity) {
        try {
            manager.remove(entity);
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /**
     * 検索
     * <ul>
     * <li>エンティティを一次キーで検索する。</li>
     * </ul>
     * @param primaryKey 一次キー
     * @return 検索した管理エンティティ
     * @throws IllegalArgumentException
     *             エンティティオブジェクト型が間違っている、または一次キーオブジェクト型が間違っているかNULLのとき
     * @see EntityManager#find(Class, Object)
     */
    public T find(final Object primaryKey) {
        try {
            return manager.find(clazz, primaryKey);
        } catch (final IllegalArgumentException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /**
     * 検索
     * <ul>
     * <li>エンティティを一次キーで検索する。</li>
     * </ul>
     * @param primaryKey 一次キー
     * @param lockMode 排他モード
     * @return 検索した管理エンティティ
     * @throws IllegalArgumentException
     *             エンティティオブジェクト型が間違っている、または一次キーオブジェクト型が間違っているかNULLのとき
     * @throws TransactionRequiredException トランザクションを開始していないとき
     * @throws OptimisticLockException 楽観ロックの例外が発生したとき
     * @throws PessimisticLockException 悲観ロックの例外が発生したとき
     * @throws LockTimeoutException 悲観ロックのタイムアウトが発生したとき
     * @throws PersistenceException 未サポートのロックを実行したとき
     * @see EntityManager#find(Class, Object, LockModeType)
     */
    public T find(final Object primaryKey, final LockModeType lockMode) {
        try {
            return manager.find(clazz, primaryKey, lockMode);
        } catch (final IllegalArgumentException | PersistenceException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /**
     * {@link #manager} の取得
     * <ul>
     * <li>ユニットテスト用のコンビニ関数。</li>
     * </ul>
     * @return {@link #manager}
     */
    EntityManager getManager() {
        return manager;
    }
}
