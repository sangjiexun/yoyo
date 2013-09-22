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
import yoyo.actor.service.app.ApplicationAnnotation.IndustryClassApplicationCDI;
import yoyo.actor.service.app.misc.IndustryClassApplication;
import yoyo.actor.service.domain.misc.IndustryClass;
import yoyo.framework.enterprise.app.SimpleRepositoryApplication;
import yoyo.framework.screen.iface.jsf.AbstractActionImpl;
import yoyo.framework.standard.shared.FilterFactory;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 業種アクション
 * @author nilcy
 */
@Named(value = "industryClassAction")
@ConversationScoped
public class IndustryClassAction extends
    AbstractActionImpl<IndustryClass, BigDecimal, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = 7243039551620767571L;
    /** 業種アプリケーションI/F */
    @Inject
    @IndustryClassApplicationCDI
    private IndustryClassApplication industryClassApplication;
    /** コンストラクタ */
    public IndustryClassAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<IndustryClass, BigDecimal, SimpleFilter> getApplication() {
        return industryClassApplication;
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
