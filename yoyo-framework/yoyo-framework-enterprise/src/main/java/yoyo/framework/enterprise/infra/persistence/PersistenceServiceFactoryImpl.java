// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import yoyo.framework.enterprise.infra.persistence.NativePersistenceService;
import yoyo.framework.enterprise.infra.persistence.PersistenceServiceFactory;
import yoyo.framework.enterprise.infra.persistence.QueryPersistenceService;
import yoyo.framework.enterprise.infra.persistence.SimplePersistenceService;
import yoyo.framework.enterprise.infra.persistence.StandardPersistenceService;
import yoyo.framework.enterprise.shared.Persistable;
/**
 * データ永続化サービスのファクトリ
 * @author nilcy
 */
@Default
@SuppressWarnings("unused")
public class PersistenceServiceFactoryImpl implements PersistenceServiceFactory {
    /** {@inheritDoc} */
    @Override
    public <E extends Persistable<ID>, ID extends Serializable> SimplePersistenceService<E, ID> createSimplePersistenceService(
        final EntityManager manager, final Class<E> clazz) {
        return new SimplePersistenceServiceImpl<E, ID>(manager, clazz);
    }
    /** {@inheritDoc} */
    @Override
    public <E extends Persistable<ID>, ID extends Serializable> NativePersistenceService<E, ID> createNativePersistenceService(
        final EntityManager manager, final Class<E> clazz) {
        return new NativePersistenceServiceImpl<E, ID>(manager, clazz);
    }
    /** {@inheritDoc} */
    @Override
    public <E extends Persistable<ID>, ID extends Serializable> StandardPersistenceService<E, ID> createStandardPersistenceService(
        final EntityManager manager, final Class<E> clazz) {
        return new StandardPersistenceServiceImpl<E, ID>(manager, clazz);
    }
    /** {@inheritDoc} */
    @Override
    public <E extends Persistable<ID>, ID extends Serializable> QueryPersistenceService<E, ID> createQueryPersistenceService(
        final EntityManager manager, final Class<E> clazz) {
        return new QueryPersistenceServiceImpl<E, ID>(manager, clazz);
    }
}
