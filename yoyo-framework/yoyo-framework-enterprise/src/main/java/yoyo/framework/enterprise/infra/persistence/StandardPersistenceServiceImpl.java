// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import yoyo.framework.enterprise.shared.Persistable;
/**
 * 標準データ永続化サービス(JPA2/JPQL)
 * <p>
 * {@link SimplePersistenceServiceImpl} へJava標準クエリ(JPQL)を追加したサービスである。
 * </p>
 * <dl>
 * <dt>不変条件</dt>
 * <dd>なし</dd>
 * </dl>
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @since JPA 1.0
 * @author nilcy
 */
@Default
public class StandardPersistenceServiceImpl<E extends Persistable<ID>, ID extends Serializable>
    extends SimplePersistenceServiceImpl<E, ID> implements StandardPersistenceService<E, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -1029454631523751121L;
    /**
     * コンストラクタ
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link SimplePersistenceServiceImpl#SimplePersistenceServiceImpl(EntityManager, Class)}
     * へ委譲する。</dd>
     * </dl>
     * @param manager エンティティマネージャ
     * @param clazz エンティティクラス
     */
    public StandardPersistenceServiceImpl(final EntityManager manager, final Class<E> clazz) {
        super(manager, clazz);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#createQuery(String, Class)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public TypedQuery<E> createQuery(final String jpql) {
        return manager.createQuery(jpql, super.clazz);
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>なし</dd>
     * <dt>事後条件</dt>
     * <dd>{@link EntityManager#createNamedQuery(String, Class)}へ委譲する。</dd>
     * </dl>
     */
    @Override
    public TypedQuery<E> createNamedQuery(final String queryName) {
        return manager.createNamedQuery(queryName, super.clazz);
    }
}
