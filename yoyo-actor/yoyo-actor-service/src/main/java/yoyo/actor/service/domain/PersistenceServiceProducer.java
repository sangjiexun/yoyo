// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain;
import java.math.BigDecimal;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import yoyo.actor.service.domain.Customer;
import yoyo.actor.service.domain.Level;
import yoyo.actor.service.domain.Member;
import yoyo.actor.service.domain.Organ;
import yoyo.actor.service.domain.Partner;
import yoyo.actor.service.domain.Supplier;
import yoyo.actor.service.domain.Title;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.CustomerPersistenceService;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.LevelPersistenceService;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.MemberPersistenceService;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.OrganPersistenceService;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.PartnerPersistenceService;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.SupplierPersistenceService;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.TitlePersistenceService;
import yoyo.framework.enterprise.infra.persistence.PersistenceServiceFactory;
import yoyo.framework.enterprise.infra.persistence.PrimaryEntityManager;
import yoyo.framework.enterprise.infra.persistence.QueryPersistenceService;
/**
 * データ永続化サービスのファクトリ
 * @author nilcy
 */
public class PersistenceServiceProducer {
    /** 基礎エンティティマネージャ */
    @Inject
    @PrimaryEntityManager
    private EntityManager manager;
    /** データ永続化サービスのファクトリ */
    @Inject
    private PersistenceServiceFactory factory;
    /** コンストラクタ */
    public PersistenceServiceProducer() {
    }
    /**
     * 得意先の先進データ永続化サービスを作成
     * @return 得意先の先進データ永続化サービス
     */
    @Produces
    @CustomerPersistenceService
    public QueryPersistenceService<Customer, BigDecimal> createCustomerPersistenceService() {
        return factory.createQueryPersistenceService(manager, Customer.class);
    }
    /**
     * 職級の先進データ永続化サービスを作成
     * @return 職級の先進データ永続化サービス
     */
    @Produces
    @LevelPersistenceService
    public QueryPersistenceService<Level, BigDecimal> createLevelPersistenceService() {
        return factory.createQueryPersistenceService(manager, Level.class);
    }
    /**
     * 社員の先進データ永続化サービスを作成
     * @return 社員の先進データ永続化サービス
     */
    @Produces
    @MemberPersistenceService
    public QueryPersistenceService<Member, BigDecimal> createMemberPersistenceService() {
        return factory.createQueryPersistenceService(manager, Member.class);
    }
    /**
     * 組織の先進データ永続化サービスを作成
     * @return 組織の先進データ永続化サービス
     */
    @Produces
    @OrganPersistenceService
    public QueryPersistenceService<Organ, BigDecimal> createOrganPersistenceService() {
        return factory.createQueryPersistenceService(manager, Organ.class);
    }
    /**
     * 外注の先進データ永続化サービスを作成
     * @return 外注の先進データ永続化サービス
     */
    @Produces
    @PartnerPersistenceService
    public QueryPersistenceService<Partner, BigDecimal> createPartnerPersistenceService() {
        return factory.createQueryPersistenceService(manager, Partner.class);
    }
    /**
     * 調達先の先進データ永続化サービスを作成
     * @return 調達先の先進データ永続化サービス
     */
    @Produces
    @SupplierPersistenceService
    public QueryPersistenceService<Supplier, BigDecimal> createSupplierPersistenceService() {
        return factory.createQueryPersistenceService(manager, Supplier.class);
    }
    /**
     * 職名の先進データ永続化サービスを作成
     * @return 職名の先進データ永続化サービス
     */
    @Produces
    @TitlePersistenceService
    public QueryPersistenceService<Title, BigDecimal> createTitlePersistenceService() {
        return factory.createQueryPersistenceService(manager, Title.class);
    }
}
