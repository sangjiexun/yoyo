// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.app.actor;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import yoyo.actor.service.app.actor.PartnerApplication;
import yoyo.actor.service.domain.Partner;
import yoyo.actor.service.domain.PartnerRepository;
import yoyo.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import yoyo.framework.enterprise.domain.SimpleRepository;
import yoyo.framework.enterprise.infra.logging.TraceLogger;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 外注アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@TraceLogger
public class PartnerApplicationImpl extends
    AbstractSimpleRepositoryApplication<Partner, BigDecimal, SimpleFilter> implements
    PartnerApplication {
    /** 製品番号 */
    private static final long serialVersionUID = -3688733534957646527L;
    /** 外注リポジトリ */
    @Inject
    private PartnerRepository repository;
    /** コンストラクタ */
    public PartnerApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Partner, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
