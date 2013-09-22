// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.screen.iface.jsf.converter;
import javax.faces.convert.FacesConverter;
import yoyo.actor.service.domain.Supplier;
/**
 * Supplier converter.
 * @author nilcy
 */
@FacesConverter(value = "supplierConverter", forClass = Supplier.class)
public final class SupplierConverter extends AbstractEntityConverter {
    /** コンストラクタ */
    public SupplierConverter() {
        super("supplierAction");
    }
}
