// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.shared;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import yoyo.framework.enterprise.shared.EnterpriseBundle;
/**
 * {@link EnterpriseBundle} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class EnterpriseBundleTest {
    @Test
    public void testGetMessage() {
        assertThat(EnterpriseBundle.getMessage("Title_UK_name"),
            is("保存できませんでした。同じキー情報があります。[組織名={0}]"));
    }
    @Test
    public void testFormatMessage() {
        assertThat(EnterpriseBundle.formatMessage("Title_UK_name", "経営企画室"),
            is("保存できませんでした。同じキー情報があります。[組織名=経営企画室]"));
    }
}
