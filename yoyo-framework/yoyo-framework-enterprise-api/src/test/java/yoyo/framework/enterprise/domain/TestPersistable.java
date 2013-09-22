// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.domain;
import javax.persistence.Entity;
import javax.persistence.Table;
import yoyo.framework.enterprise.domain.AbstractPersistable;
/**
 * テスト永続可能エンティティ
 * @author nilcy
 */
@Entity
@Table(name = "TestPersistable")
@SuppressWarnings("all")
public class TestPersistable extends AbstractPersistable<TestPersistable> {
    private static final long serialVersionUID = 3620864252783910657L;
    public TestPersistable() {
    }
}
