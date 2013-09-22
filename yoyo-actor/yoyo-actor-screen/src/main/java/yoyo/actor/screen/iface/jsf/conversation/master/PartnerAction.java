// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.screen.iface.jsf.conversation.master;
import java.math.BigDecimal;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import yoyo.actor.service.app.ApplicationAnnotation.PartnerApplicationCDI;
import yoyo.actor.service.app.actor.PartnerApplication;
import yoyo.actor.service.domain.Partner;
import yoyo.actor.service.domain.PartnerFactory;
import yoyo.framework.enterprise.app.SimpleRepositoryApplication;
import yoyo.framework.screen.iface.jsf.AbstractActionImpl;
import yoyo.framework.standard.shared.FilterFactory;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 外注アクション
 * @author nilcy
 */
@Named(value = "partnerAction")
@ConversationScoped
public class PartnerAction extends AbstractActionImpl<Partner, BigDecimal, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = -1406530105042380063L;
    /** 外注アプリケーションI/F */
    @Inject
    @PartnerApplicationCDI
    private PartnerApplication partnerApplication;
    /** コンストラクタ */
    public PartnerAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<Partner, BigDecimal, SimpleFilter> getApplication() {
        return partnerApplication;
    }
    /** {@inheritDoc} */
    @Override
    protected Partner createInstance() {
        return new PartnerFactory().create();
    }
    /** {@inheritDoc} */
    @Override
    protected boolean beforeSave() {
        final Partner c = getSelected();
        c.getContact().setName(
            StringUtils.defaultIfEmpty(c.getContact().getName(), c.getFamilyName()));
        return super.beforeSave();
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
