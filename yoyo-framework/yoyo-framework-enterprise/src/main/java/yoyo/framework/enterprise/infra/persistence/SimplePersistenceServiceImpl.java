// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.persistence;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Map;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import yoyo.framework.enterprise.shared.Persistable;
/**
 * 基本データ永続化サービス(JPA2)
 * <dl>
 * <dt>不変条件</dt>
 * <dd>
 * <ol>
 * <li>インスタンス化するときにエンティティのマネージャとクラスを保持して、そのあと変更しない。</li>
 * <li>エンティティのライフサイクル(コンテキスト状態)に応じたJPAの基本操作を提供すること。</li>
 * <li>DBトランザクションに関する操作を実行しない。(暗黙的にトランザクションタイプ=JTAを想定している)</li>
 * </ol>
 * </dd>
 * </dl>
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @since JPA 2.1
 * @author nilcy
 */
@Default
public class SimplePersistenceServiceImpl<E extends Persistable<ID>, ID extends Serializable>
    implements SimplePersistenceService<E, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -2663309706616831662L;
    /** エンティティマネージャ */
    protected EntityManager manager;
    /** エンティティクラス */
    protected Class<E> clazz;
    /**
     * コンストラクタ(汎用)
     * <ol>
     * <li>各エンティティに依存しない汎用的な永続化サービスのために使用すること。</li>
     * <li>データ永続化はインフラストラクチャ層のサービスで、エンティティに依存すべきでないため<b>推奨</b>する。</li>
     * </ol>
     * <dl>
     * <dt>事前条件</dt>
     * <dd>引数がNULLでないこと。</dd>
     * <dt>事後条件</dt>
     * <dd>引数をインスタンス変数へ保持する。</dd>
     * </dl>
     * @param manager エンティティマネージャ
     * @param clazz エンティティクラス
     */
    public SimplePersistenceServiceImpl(final EntityManager manager, final Class<E> clazz) {
        assert manager != null && clazz != null;
        this.manager = manager;
        this.clazz = clazz;
    }
    /**
     * コンストラクタ(個別)
     * <ol>
     * <li>各エンティティに依存した個別の永続化サービスのために使用すること。</li>
     * <li>データ永続化はインフラストラクチャ層のサービスで、エンティティに依存すべきでないため<b>非推奨</b>とする。</li>
     * <li>※(具象クラスのため)エンティティ型からエンティティクラスを実行時に取得できるため引数は不要となる。</li>
     * </ol>
     * <dl>
     * <dt>事前条件</dt>
     * <dd>引数がNULLでないこと。</dd>
     * <dt>事後条件</dt>
     * <dd>引数をインスタンス変数へ保持する。エンティティクラスは実行時に取得してインスタンス変数へ保持する。</dd>
     * </dl>
     * @param manager エンティティマネージャ
     */
    @SuppressWarnings("unchecked")
    public SimplePersistenceServiceImpl(final EntityManager manager) {
        assert manager != null;
        this.manager = manager;
        clazz = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#persist(Object)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public <S extends E> void persist(final S entity) {
        manager.persist(entity);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#find(Class, Object)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public E find(final ID id) {
        return manager.find(clazz, id);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#find(Class, Object, LockModeType)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public E find(final ID id, final LockModeType lockModeType) {
        return manager.find(clazz, id, lockModeType);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#find(Class, Object, Map)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public E find(final ID id, final Map<String, Object> properties) {
        return manager.find(clazz, id, properties);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#find(Class, Object, LockModeType)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public E find(final ID id, final LockModeType lockModeType, final Map<String, Object> properties) {
        return manager.find(clazz, id, lockModeType);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#merge(Object)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public <S extends E> S merge(final S entity) {
        return manager.merge(entity);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#remove(Object)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void remove(final E entity) {
        manager.remove(entity);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#refresh(Object)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void refresh(final E entity) {
        manager.refresh(entity);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#refresh(Object, LockModeType)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void refresh(final E entity, final LockModeType lockModeType) {
        manager.refresh(entity, lockModeType);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#refresh(Object, Map)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void refresh(final E entity, final Map<String, Object> properties) {
        manager.refresh(entity, properties);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#refresh(Object, LockModeType, Map)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void refresh(final E entity, final LockModeType lockModeType,
        final Map<String, Object> properties) {
        manager.refresh(entity, lockModeType, properties);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#lock(Object, LockModeType)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void lock(final E entity, final LockModeType lockModeType) {
        manager.lock(entity, lockModeType);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#lock(Object, LockModeType, Map)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void lock(final E entity, final LockModeType lockModeType,
        final Map<String, Object> properties) {
        manager.lock(entity, lockModeType, properties);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#flush()}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void flush() {
        manager.flush();
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#detach(Object)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void detach(final E entity) {
        manager.detach(entity);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#contains(Object)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public boolean contains(final E entity) {
        return manager.contains(entity);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link TypedQuery#setFirstResult(int)}, {@link TypedQuery#setMaxResults(int)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public TypedQuery<E> createRangeQuery(final TypedQuery<E> query, final int offset,
        final int maxsize) {
        return query.setFirstResult(offset).setMaxResults(maxsize);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link TypedQuery#getResultList()}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public Collection<E> findMany(final TypedQuery<E> query) {
        return query.getResultList();
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link TypedQuery#getSingleResult()}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public E findOne(final TypedQuery<E> query) {
        return query.getSingleResult();
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#getProperties()}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public Map<String, Object> getProperties() {
        return manager.getProperties();
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#setProperty(String, Object)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public void setProperty(final String propertyName, final Object value) {
        manager.setProperty(propertyName, value);
    }
}
