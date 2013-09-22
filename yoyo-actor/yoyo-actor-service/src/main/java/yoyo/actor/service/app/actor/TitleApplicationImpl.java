// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.app.actor;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import yoyo.actor.service.app.actor.TitleApplication;
import yoyo.actor.service.domain.Title;
import yoyo.actor.service.domain.TitleRepository;
import yoyo.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import yoyo.framework.enterprise.domain.SimpleRepository;
import yoyo.framework.enterprise.shared.Tracer;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 職名アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@Tracer
public class TitleApplicationImpl extends
    AbstractSimpleRepositoryApplication<Title, BigDecimal, SimpleFilter> implements
    TitleApplication {
    /** 製品番号 */
    private static final long serialVersionUID = -2055548765950043371L;
    /** 職名リポジトリ */
    @Inject
    private TitleRepository repository;
    /** コンストラクタ */
    public TitleApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<Title, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
