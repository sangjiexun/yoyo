// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain.misc;
import java.math.BigDecimal;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import yoyo.actor.service.domain.misc.IndustryClass;
import yoyo.actor.service.domain.misc.PersistenceServiceAnnotation.IndustryClassPersistenceService;
import yoyo.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import yoyo.framework.enterprise.infra.logging.TraceLogger;
import yoyo.framework.enterprise.infra.persistence.QueryPersistenceService;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 業種リポジトリ
 * @author nilcy
 */
@Default
@TraceLogger
public class IndustryClassRepositoryImpl extends
    AbstractQueryRepositoryImpl<IndustryClass, BigDecimal, SimpleFilter> implements
    IndustryClassRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 先進データ永続化サービス */
    @Inject
    @IndustryClassPersistenceService
    private QueryPersistenceService<IndustryClass, BigDecimal> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<IndustryClass, BigDecimal> getPersistenceService() {
        return service;
    }
}
