// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain;
import java.math.BigDecimal;
import yoyo.actor.service.domain.Organ;
import yoyo.framework.enterprise.domain.SimpleRepository;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 組織リポジトリI/F
 * @author nilcy
 */
public interface OrganRepository extends SimpleRepository<Organ, BigDecimal, SimpleFilter> {
}
