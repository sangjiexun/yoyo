// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain.misc;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import yoyo.framework.enterprise.domain.AbstractVersionable_;
/**
 * 上場先のメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(ListedSection.class)
public class ListedSection_ extends AbstractVersionable_ {
    /** 上場先 */
    public static volatile SingularAttribute<ListedSection, String> section;
}
