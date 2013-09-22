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
import yoyo.actor.service.app.ApplicationAnnotation.TitleApplicationCDI;
import yoyo.actor.service.app.actor.TitleApplication;
import yoyo.actor.service.domain.Title;
import yoyo.framework.enterprise.app.SimpleRepositoryApplication;
import yoyo.framework.screen.iface.jsf.AbstractActionImpl;
import yoyo.framework.standard.shared.FilterFactory;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 職名アクション
 * @author nilcy
 */
@Named(value = "titleAction")
@ConversationScoped
public class TitleAction extends AbstractActionImpl<Title, BigDecimal, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = -1742312463790367432L;
    /** 職名アプリケーションI/F */
    @Inject
    @TitleApplicationCDI
    private TitleApplication titleApplication;
    /** コンストラクタ */
    public TitleAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<Title, BigDecimal, SimpleFilter> getApplication() {
        return titleApplication;
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
