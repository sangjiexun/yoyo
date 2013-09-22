// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain.misc;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
import yoyo.actor.service.domain.misc.News;
import yoyo.actor.service.domain.misc.NewsRepository;
import yoyo.actor.service.domain.misc.NewsRepositoryImpl;
import yoyo.framework.enterprise.domain.ConstraintsException;
/**
 * {@link NewsRepositoryImpl} のユニットテスト
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class NewsRepositoryImplTest {
    @Inject
    private NewsRepository testee;
    @Inject
    private Logger log;
    @Test
    public final void test() throws ConstraintsException {
        testee.save(new News());
    }
}
