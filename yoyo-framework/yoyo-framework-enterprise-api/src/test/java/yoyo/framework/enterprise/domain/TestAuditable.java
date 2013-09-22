// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
import yoyo.framework.enterprise.domain.AbstractAuditable;
/**
 * テスト監査可能エンティティ
 * @author nilcy
 */
@Entity
@Table(name = "TestAuditable")
// @SuppressWarnings("all")
public class TestAuditable extends AbstractAuditable<TestAuditable> {
    /** 識別番号 */
    private static final long serialVersionUID = 3834376793666440948L;
}
