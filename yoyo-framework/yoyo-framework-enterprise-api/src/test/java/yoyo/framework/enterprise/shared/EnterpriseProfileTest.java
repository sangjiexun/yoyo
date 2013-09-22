// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.shared;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import yoyo.framework.enterprise.shared.EnterpriseProfile;
/**
 * {@link EnterpriseProfile} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class EnterpriseProfileTest {
    @Test
    public void test() {
        assertThat(EnterpriseProfile.MAX_RESULTS, is(1000));
        assertThat(EnterpriseProfile.BUNDLE_BASENAME, is("yoyo.framework.enterprise.bundle"));
        assertThat(EnterpriseProfile.REPORT_TO, is("yoyo@gmail.com"));
        assertThat(EnterpriseProfile.REPORT_SUBJECT, is("Activities Report"));
        assertThat(EnterpriseProfile.REPORT_MAILER, is("Java Mail Client"));
    }
}
