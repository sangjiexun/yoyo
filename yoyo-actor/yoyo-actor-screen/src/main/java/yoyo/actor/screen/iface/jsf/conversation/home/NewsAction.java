// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.screen.iface.jsf.conversation.home;
import java.math.BigDecimal;
import yoyo.actor.service.domain.misc.News;
import yoyo.framework.screen.iface.jsf.SimpleAction;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * お知らせアクションI/F
 * @author nilcy
 */
public interface NewsAction extends SimpleAction<News, BigDecimal, SimpleFilter> {
}
