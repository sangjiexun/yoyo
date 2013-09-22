// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain.misc;
import java.math.BigDecimal;
import yoyo.actor.service.domain.misc.IndustryClass;
import yoyo.framework.enterprise.domain.SimpleRepository;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 業種リポジトリI/F
 * @author nilcy
 */
public interface IndustryClassRepository extends
    SimpleRepository<IndustryClass, BigDecimal, SimpleFilter> {
}
