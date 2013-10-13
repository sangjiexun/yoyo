// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.logging;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
/**
 * ユニットテストのデプロイメント
 * @author nilcy
 */
final class ArquillianArchive {
    /** 非公開コンストラクタ */
    private ArquillianArchive() {
    }
    /**
     * デフォルトのデプロイメント
     * @return デフォルトのアーカイブ
     */
    static JavaArchive defaultDeployment() {
        return ShrinkWrap
            .create(JavaArchive.class)
            .addPackages(true, "yoyo.framework.standard")
            .addPackages(true, "yoyo.framework.enterprise.shared",
                "yoyo.framework.enterprise.infra.logging")
            .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
}
