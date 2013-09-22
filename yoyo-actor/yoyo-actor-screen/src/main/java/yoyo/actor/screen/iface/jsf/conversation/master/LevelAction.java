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
import yoyo.actor.service.app.ApplicationAnnotation.LevelApplicationCDI;
import yoyo.actor.service.app.actor.LevelApplication;
import yoyo.actor.service.domain.Level;
import yoyo.framework.enterprise.app.SimpleRepositoryApplication;
import yoyo.framework.screen.iface.jsf.AbstractActionImpl;
import yoyo.framework.standard.shared.FilterFactory;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 職級アクション
 * @author nilcy
 */
@Named(value = "levelAction")
@ConversationScoped
public class LevelAction extends AbstractActionImpl<Level, BigDecimal, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = 944558410807492976L;
    /** 職級アプリケーションI/F */
    @Inject
    @LevelApplicationCDI
    private LevelApplication levelApplication;
    /** コンストラクタ */
    public LevelAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<Level, BigDecimal, SimpleFilter> getApplication() {
        return levelApplication;
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
