// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.app.actor;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import yoyo.actor.service.app.actor.CustomerApplication;
import yoyo.actor.service.domain.Customer;
import yoyo.actor.service.domain.CustomerRepository;
import yoyo.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import yoyo.framework.enterprise.domain.SimpleRepository;
import yoyo.framework.enterprise.infra.logging.TraceLogger;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 得意先アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@TraceLogger
public class CustomerApplicationImpl extends
    AbstractSimpleRepositoryApplication<Customer, BigDecimal, SimpleFilter> implements
    CustomerApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 得意先リポジトリ */
    @Inject
    private CustomerRepository repository;
    /** コンストラクタ */
    public CustomerApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Customer, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
