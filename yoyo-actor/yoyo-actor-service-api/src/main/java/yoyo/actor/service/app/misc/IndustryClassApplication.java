// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.app.misc;
import java.math.BigDecimal;
import javax.ejb.Local;
import yoyo.actor.service.domain.misc.IndustryClass;
import yoyo.framework.enterprise.app.SimpleRepositoryApplication;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 業種アプリケーションI/F
 * @author nilcy
 */
@Local
public interface IndustryClassApplication extends
    SimpleRepositoryApplication<IndustryClass, BigDecimal, SimpleFilter> {
}
