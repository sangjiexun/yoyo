// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.shared;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
/**
 * ユニットテストのデプロイメント
 * @author nilcy
 */
final class ArquillianDeployment {
    /** 非公開コンストラクタ */
    private ArquillianDeployment() {
    }
    /**
     * デフォルトのデプロイメント
     * @return デフォルトのアーカイブ
     */
    static JavaArchive defaultDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "yoyo.framework.enterprise.shared.jar")
            .addPackages(true, "yoyo.framework.standard", "yoyo.framework.enterprise.shared")
            .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
}
