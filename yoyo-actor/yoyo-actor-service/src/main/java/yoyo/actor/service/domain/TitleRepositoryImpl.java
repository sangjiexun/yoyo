// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain;
import java.math.BigDecimal;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import yoyo.actor.service.domain.Title;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.TitlePersistenceService;
import yoyo.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import yoyo.framework.enterprise.infra.logging.TraceLogger;
import yoyo.framework.enterprise.infra.persistence.QueryPersistenceService;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * Title repository implementation.
 * @author nilcy
 */
@Default
@TraceLogger
public class TitleRepositoryImpl extends
    AbstractQueryRepositoryImpl<Title, BigDecimal, SimpleFilter> implements TitleRepository {
    /** 製品番号 */
    private static final long serialVersionUID = -1122126676114741118L;
    /** 先進データ永続化サービス */
    @Inject
    @TitlePersistenceService
    private QueryPersistenceService<Title, BigDecimal> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<Title, BigDecimal> getPersistenceService() {
        return service;
    }
}
