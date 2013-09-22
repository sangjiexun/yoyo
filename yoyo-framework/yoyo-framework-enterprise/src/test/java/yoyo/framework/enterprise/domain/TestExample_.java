// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.domain;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import yoyo.framework.enterprise.domain.AbstractAuditable_;
/**
 * テスト参照オブジェクトのメタモデル
 * @author nilcy
 */
// CHECKSTYLE:OFF
@StaticMetamodel(TestExample.class)
@SuppressWarnings("all")
public class TestExample_ extends AbstractAuditable_ {
    public static volatile SingularAttribute<TestExample, String> code;
}
