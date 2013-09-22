// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.app.misc;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import yoyo.actor.service.app.misc.ListedSectionApplication;
import yoyo.actor.service.domain.misc.ListedSection;
import yoyo.actor.service.domain.misc.ListedSectionRepository;
import yoyo.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import yoyo.framework.enterprise.domain.SimpleRepository;
import yoyo.framework.enterprise.shared.Tracer;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 上場先アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@Tracer
public class ListedSectionApplicationImpl extends
    AbstractSimpleRepositoryApplication<ListedSection, BigDecimal, SimpleFilter> implements
    ListedSectionApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 上場先リポジトリ */
    @Inject
    private ListedSectionRepository repository;
    /** コンストラクタ */
    public ListedSectionApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<ListedSection, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
