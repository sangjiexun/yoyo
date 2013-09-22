// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain;
import java.math.BigDecimal;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import yoyo.actor.service.domain.Supplier;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.SupplierPersistenceService;
import yoyo.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import yoyo.framework.enterprise.infra.persistence.QueryPersistenceService;
import yoyo.framework.enterprise.shared.Tracer;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * Supplier repository implementation.
 * @author nilcy
 */
@Default
@Tracer
public class SupplierRepositoryImpl extends
    AbstractQueryRepositoryImpl<Supplier, BigDecimal, SimpleFilter> implements SupplierRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 3003296026718089910L;
    /** 先進データ永続化サービス */
    @Inject
    @SupplierPersistenceService
    private QueryPersistenceService<Supplier, BigDecimal> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<Supplier, BigDecimal> getPersistenceService() {
        return service;
    }
}
