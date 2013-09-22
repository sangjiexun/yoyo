// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import yoyo.actor.service.domain.parts.CustomerContact;
/**
 * 得意先のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Customer.class)
public class Customer_ extends Company_ {
    /** 連絡先 */
    public static volatile SingularAttribute<Customer, CustomerContact> contact;
}
