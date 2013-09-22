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
import org.apache.commons.lang3.StringUtils;
import yoyo.actor.service.app.ApplicationAnnotation.SupplierApplicationCDI;
import yoyo.actor.service.app.actor.SupplierApplication;
import yoyo.actor.service.domain.Supplier;
import yoyo.actor.service.domain.SupplierFactory;
import yoyo.framework.enterprise.app.SimpleRepositoryApplication;
import yoyo.framework.screen.iface.jsf.AbstractActionImpl;
import yoyo.framework.standard.shared.FilterFactory;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 調達先アクション
 * @author nilcy
 */
@Named(value = "supplierAction")
@ConversationScoped
public class SupplierAction extends AbstractActionImpl<Supplier, BigDecimal, SimpleFilter> {
    /** 製品番号 */
    private static final long serialVersionUID = 873776474936603723L;
    /** 調達先アプリケーションI/F */
    @Inject
    @SupplierApplicationCDI
    private SupplierApplication supplierApplication;
    /** コンストラクタ */
    public SupplierAction() {
    }
    /** {@inheritDoc} */
    @Override
    public SimpleRepositoryApplication<Supplier, BigDecimal, SimpleFilter> getApplication() {
        return supplierApplication;
    }
    /** {@inheritDoc} */
    @Override
    protected Supplier createInstance() {
        return new SupplierFactory().create();
    }
    /** {@inheritDoc} */
    @Override
    protected boolean beforeSave() {
        final Supplier c = getSelected();
        c.getAddress().setName(
            StringUtils.defaultIfEmpty(c.getAddress().getName(), c.getOfficialName()));
        c.getContact().setName(
            StringUtils.defaultIfEmpty(c.getContact().getName(), c.getOfficialName()));
        return super.beforeSave();
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleFilter createFilter() {
        return FilterFactory.createSimpleFilter();
    }
}
