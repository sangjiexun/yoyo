// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain;
import java.math.BigDecimal;
import yoyo.actor.service.domain.Supplier;
import yoyo.framework.enterprise.domain.SimpleRepository;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 調達先リポジトリI/F
 * @author nilcy
 */
public interface SupplierRepository extends SimpleRepository<Supplier, BigDecimal, SimpleFilter> {
}
