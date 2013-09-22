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
import yoyo.actor.service.app.ApplicationAnnotation.ListedSectionApplicationCDI;
import yoyo.actor.service.app.misc.ListedSectionApplication;
import yoyo.actor.service.domain.misc.ListedSection;
import yoyo.framework.enterprise.app.SimpleRepositoryApplication;
import yoyo.framework.screen.iface.jsf.AbstractActionImpl;
import yoyo.framework.standard.shared.FilterFactory;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 上場先アクション
 * @author nilcy
 */
@Named(value = "listedSectionAction")
@ConversationScoped
public class ListedSectionAction extends
    AbstractActionImpl<ListedSection, BigDecimal, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = 7243039551620767571L;
    /** 上場先アプリケーションI/F */
    @Inject
    @ListedSectionApplicationCDI
    private ListedSectionApplication listedSectionApplication;
    /** コンストラクタ */
    public ListedSectionAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<ListedSection, BigDecimal, SimpleFilter> getApplication() {
        return listedSectionApplication;
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
