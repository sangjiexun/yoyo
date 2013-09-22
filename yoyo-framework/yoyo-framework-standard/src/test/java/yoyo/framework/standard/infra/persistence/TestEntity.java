// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.persistence;
import static javax.persistence.GenerationType.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
/**
 * テスト用エンティティ
 * @author nilcy
 */
@Entity
@SuppressWarnings("all")
public class TestEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    @Version
    private Long version;
    /** コンストラクタ */
    public TestEntity() {
    }
    /**
     * {@link #id} の取得
     * @return {@link #id}
     */
    public Long getId() {
        return id;
    }
    /**
     * {@link #id} の設定
     * @param id {@link #id}
     */
    public void setId(final Long id) {
        this.id = id;
    }
    /**
     * {@link #name} の取得
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }
    /**
     * {@link #name} の設定
     * @param name {@link #name}
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * {@link #version} の取得
     * @return {@link #version}
     */
    public Long getVersion() {
        return version;
    }
    /**
     * {@link #version} の設定
     * @param version {@link #version}
     */
    public void setVersion(final Long version) {
        this.version = version;
    }
}
