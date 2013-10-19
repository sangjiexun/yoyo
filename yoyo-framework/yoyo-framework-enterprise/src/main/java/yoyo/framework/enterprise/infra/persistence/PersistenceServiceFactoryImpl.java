// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import yoyo.framework.enterprise.shared.Persistable;
/**
 * データ永続化サービスのファクトリ
 * <dl>
 * <dt>不変条件</dt>
 * <dd>なし</dd>
 * </dl>
 * @author nilcy
 */
@Default
@SuppressWarnings("unused")
public class PersistenceServiceFactoryImpl implements PersistenceServiceFactory {
    /**
     * {@inheritDoc}
     * <ol>
     * <li>{@link SimplePersistenceServiceImpl#SimplePersistenceServiceImpl(EntityManager, Class)}
     * へ委譲する。</li>
     * </ol>
     */
    @Override
    public <E extends Persistable<ID>, ID extends Serializable> SimplePersistenceService<E, ID> createSimplePersistenceService(
        final EntityManager manager, final Class<E> clazz) {
        return new SimplePersistenceServiceImpl<E, ID>(manager, clazz);
    }
    /**
     * {@inheritDoc}
     * <ol>
     * <li>{@link NativePersistenceServiceImpl#NativePersistenceServiceImpl(EntityManager, Class)}
     * へ委譲する。</li>
     * </ol>
     */
    @Override
    public <E extends Persistable<ID>, ID extends Serializable> NativePersistenceService<E, ID> createNativePersistenceService(
        final EntityManager manager, final Class<E> clazz) {
        return new NativePersistenceServiceImpl<E, ID>(manager, clazz);
    }
    /**
     * {@inheritDoc}
     * <ol>
     * <li>
     * {@link StandardPersistenceServiceImpl#StandardPersistenceServiceImpl(EntityManager, Class)}
     * へ委譲する。</li>
     * </ol>
     */
    @Override
    public <E extends Persistable<ID>, ID extends Serializable> StandardPersistenceService<E, ID> createStandardPersistenceService(
        final EntityManager manager, final Class<E> clazz) {
        return new StandardPersistenceServiceImpl<E, ID>(manager, clazz);
    }
    /**
     * {@inheritDoc}
     * <ol>
     * <li>{@link QueryPersistenceServiceImpl#QueryPersistenceServiceImpl(EntityManager, Class)}
     * へ委譲する。</li>
     * </ol>
     */
    @Override
    public <E extends Persistable<ID>, ID extends Serializable> QueryPersistenceService<E, ID> createQueryPersistenceService(
        final EntityManager manager, final Class<E> clazz) {
        return new QueryPersistenceServiceImpl<E, ID>(manager, clazz);
    }
}
