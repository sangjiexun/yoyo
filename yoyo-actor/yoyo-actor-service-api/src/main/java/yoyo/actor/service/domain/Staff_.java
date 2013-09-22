// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import yoyo.framework.enterprise.domain.AbstractVersionable_;
/**
 * 職員のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(Staff.class)
public class Staff_ extends AbstractVersionable_ {
    /** 姓 */
    public static volatile SingularAttribute<Staff<?>, String> familyName;
    /** 名 */
    public static volatile SingularAttribute<Staff<?>, String> givenName;
    /** 姓カナ */
    public static volatile SingularAttribute<Staff<?>, String> familyAlias;
    /** 名カナ */
    public static volatile SingularAttribute<Staff<?>, String> givenAlias;
}
