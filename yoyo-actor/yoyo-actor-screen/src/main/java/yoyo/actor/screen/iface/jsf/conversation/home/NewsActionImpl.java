// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.screen.iface.jsf.conversation.home;
import java.math.BigDecimal;
import java.util.Date;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import yoyo.actor.service.app.ApplicationAnnotation.NewsApplicationCDI;
import yoyo.actor.service.app.misc.NewsApplication;
import yoyo.actor.service.domain.misc.News;
import yoyo.actor.service.domain.misc.NewsFactory;
import yoyo.framework.enterprise.app.SimpleRepositoryApplication;
import yoyo.framework.screen.iface.jsf.AbstractActionImpl;
import yoyo.framework.standard.shared.FilterFactory;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * お知らせアクション
 * @author nilcy
 */
@Named(value = "newsAction")
@ConversationScoped
@Default
public class NewsActionImpl extends AbstractActionImpl<News, BigDecimal, SimpleFilter> implements
    NewsAction {
    /** 製品番号 */
    private static final long serialVersionUID = 7243039551620767571L;
    /** お知らせアプリケーションI/F */
    @Inject
    @NewsApplicationCDI
    private NewsApplication newsApplication;
    /** コンストラクタ */
    public NewsActionImpl() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<News, BigDecimal, SimpleFilter> getApplication() {
        return newsApplication;
    }
    /**
     * {@inheritDoc}
     * <ul>
     * <li>set published date.</li>
     * </ul>
     * @return {@inheritDoc}
     */
    @Override
    protected News createInstance() {
        final News i = new NewsFactory().create();
        i.setPublished(new Date());
        return i;
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
