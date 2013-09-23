// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.persistence;
import java.io.Serializable;
import java.util.Map;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.metamodel.Metamodel;
import org.slf4j.Logger;
import yoyo.framework.standard.infra.logging.LoggingService;
import yoyo.framework.standard.shared.Service;
/**
 * データ永続化の基本操作
 * @param <T> エンティティオブジェクト型
 * @author nilcy
 */
public class SimplePersistenceImpl<T extends Serializable> implements Service, SimplePersistence<T> {
    /** 製品番号 */
    private static final long serialVersionUID = -6904142180129336340L;
    /** エンティティマネージャ */
    private final EntityManager manager;
    /** エンティティクラス */
    private final Class<T> clazz;
    /** ロガー */
    private static final Logger LOG = LoggingService.getLogger(SimplePersistenceImpl.class);
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
    public SimplePersistenceImpl(final EntityManager manager, final Class<T> clazz) {
        assert (manager != null) && (clazz != null);
        this.manager = manager;
        this.clazz = clazz;
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
    /** {@inheritDoc} */
    @Override
    public void persist(final T entity) {
        try {
            manager.persist(entity);
        } catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /** {@inheritDoc} */
    @Override
    public T merge(final T entity) {
        try {
            return manager.merge(entity);
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /** {@inheritDoc} */
    @Override
    public void remove(final T entity) {
        try {
            manager.remove(entity);
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /** {@inheritDoc} */
    @Override
    public T find(final Object primaryKey) {
        try {
            return manager.find(clazz, primaryKey);
        } catch (final IllegalArgumentException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /** {@inheritDoc} */
    @Override
    public T find(final Object primaryKey, final LockModeType lockMode) {
        try {
            return manager.find(clazz, primaryKey, lockMode);
        } catch (final IllegalArgumentException | PersistenceException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /** {@inheritDoc} */
    @Override
    public T getReference(final Object primaryKey) {
        try {
            return manager.getReference(clazz, primaryKey);
        } catch (final IllegalArgumentException | EntityNotFoundException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /** {@inheritDoc} */
    @Override
    public void flush() {
        try {
            manager.flush();
        } catch (final PersistenceException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /** {@inheritDoc} */
    @Override
    public void setFlushMode(final FlushModeType flushMode) {
        manager.setFlushMode(flushMode);
    }
    /** {@inheritDoc} */
    @Override
    public FlushModeType getFlushMode() {
        return manager.getFlushMode();
    }
    /** {@inheritDoc} */
    @Override
    public void lock(final T entity, final LockModeType lockMode) {
        manager.lock(entity, lockMode);
    }
    /** {@inheritDoc} */
    @Override
    public void refresh(final T entity) {
    }
    /** {@inheritDoc} */
    @Override
    public void refresh(final T entity, final LockModeType lockMode) {
    }
    /** {@inheritDoc} */
    @Override
    public void clear() {
        manager.clear();
    }
    /** {@inheritDoc} */
    @Override
    public void detach(final T entity) {
        try {
            manager.detach(entity);
        } catch (final IllegalArgumentException e) {
            LOG.warn(e.getLocalizedMessage(), e);
            throw e;
        }
    }
    /** {@inheritDoc} */
    @Override
    public boolean contains(final T entity) {
        return false;
    }
    /** {@inheritDoc} */
    @Override
    public LockModeType getLockMode(final Object entity) {
        return manager.getLockMode(entity);
    }
    /** {@inheritDoc} */
    @Override
    public void setProperty(final String name, final Object value) {
        manager.setProperty(name, value);
    }
    /** {@inheritDoc} */
    @Override
    public Map<String, Object> getProperties() {
        return manager.getProperties();
    }
    /** {@inheritDoc} */
    @Override
    public void joinTransaction() {
        manager.joinTransaction();
    }
    /** {@inheritDoc} */
    @Override
    public boolean isJoinedToTransaction() {
        return manager.isJoinedToTransaction();
    }
    /** {@inheritDoc} */
    @Override
    public void close() {
        manager.close();
    }
    /** {@inheritDoc} */
    @Override
    public boolean isOpen() {
        return manager.isOpen();
    }
    /** {@inheritDoc} */
    @Override
    public EntityTransaction getTransaction() {
        return manager.getTransaction();
    }
    /** {@inheritDoc} */
    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return manager.getEntityManagerFactory();
    }
    /** {@inheritDoc} */
    @Override
    public Metamodel getMetamodel() {
        return manager.getMetamodel();
    }
}
