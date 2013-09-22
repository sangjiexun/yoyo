// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.app;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import yoyo.actor.service.app.ApplicationAnnotation.CustomerApplicationCDI;
import yoyo.actor.service.app.ApplicationAnnotation.IndustryClassApplicationCDI;
import yoyo.actor.service.app.ApplicationAnnotation.LevelApplicationCDI;
import yoyo.actor.service.app.ApplicationAnnotation.ListedSectionApplicationCDI;
import yoyo.actor.service.app.ApplicationAnnotation.MemberApplicationCDI;
import yoyo.actor.service.app.ApplicationAnnotation.NewsApplicationCDI;
import yoyo.actor.service.app.ApplicationAnnotation.OrganApplicationCDI;
import yoyo.actor.service.app.ApplicationAnnotation.PartnerApplicationCDI;
import yoyo.actor.service.app.ApplicationAnnotation.SupplierApplicationCDI;
import yoyo.actor.service.app.ApplicationAnnotation.TitleApplicationCDI;
import yoyo.actor.service.app.actor.CustomerApplication;
import yoyo.actor.service.app.actor.LevelApplication;
import yoyo.actor.service.app.actor.MemberApplication;
import yoyo.actor.service.app.actor.OrganApplication;
import yoyo.actor.service.app.actor.PartnerApplication;
import yoyo.actor.service.app.actor.SupplierApplication;
import yoyo.actor.service.app.actor.TitleApplication;
import yoyo.actor.service.app.misc.IndustryClassApplication;
import yoyo.actor.service.app.misc.ListedSectionApplication;
import yoyo.actor.service.app.misc.NewsApplication;
/**
 * 関係先アプリケーションのプロデューサ
 * @author nilcy
 */
public class ApplicationProducer {
    /** 得意先アプリケーションI/F */
    @EJB
    @Produces
    @CustomerApplicationCDI
    private CustomerApplication customerApplication;
    /** 職級アプリケーションI/F */
    @EJB
    @Produces
    @LevelApplicationCDI
    private LevelApplication levelApplication;
    /** 社員アプリケーションI/F */
    @EJB
    @Produces
    @MemberApplicationCDI
    private MemberApplication memberApplication;
    /** 組織アプリケーションI/F */
    @EJB
    @Produces
    @OrganApplicationCDI
    private OrganApplication organApplication;
    /** 外注アプリケーションI/F */
    @EJB
    @Produces
    @PartnerApplicationCDI
    private PartnerApplication partnerApplication;
    /** 調達先アプリケーションI/F */
    @EJB
    @Produces
    @SupplierApplicationCDI
    private SupplierApplication supplierApplication;
    /** 職名アプリケーションI/F */
    @EJB
    @Produces
    @TitleApplicationCDI
    private TitleApplication titleApplication;
    /** 上場先アプリケーションI/F */
    @EJB
    @Produces
    @ListedSectionApplicationCDI
    private ListedSectionApplication listedSectionApplication;
    /** お知らせアプリケーションI/F */
    @EJB
    @Produces
    @NewsApplicationCDI
    private NewsApplication newsApplication;
    /** 業種アプリケーションI/F */
    @EJB
    @Produces
    @IndustryClassApplicationCDI
    private IndustryClassApplication industryClassApplication;
}
