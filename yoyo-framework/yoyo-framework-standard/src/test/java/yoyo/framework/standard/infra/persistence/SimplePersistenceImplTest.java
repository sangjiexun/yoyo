// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.persistence;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import yoyo.framework.standard.infra.logging.LoggingService;
/**
 * {@link SimplePersistenceImpl}
 * @author nilcy
 */
@SuppressWarnings("all")
public class SimplePersistenceImplTest {
    private EntityManager manager;
    private SimplePersistence<TestEntity> testee;
    private static final Logger LOG = LoggingService.getLogger();
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Before
    public void setUp() throws Exception {
        manager = Persistence.createEntityManagerFactory("primary").createEntityManager();
        testee = new SimplePersistenceImpl(manager, TestEntity.class);
        // testee.getManager().getTransaction().begin();
    }
    @After
    public void tearDown() throws Exception {
        // testee.getManager().getTransaction().rollback();
    }
    @Test
    public final void testSimplePersistence() {
        // case: success
        assertThat(new SimplePersistenceImpl(manager, TestEntity.class), is(not(nullValue())));
        // case: exception
        thrown.handleAssertionErrors();
        thrown.expect(AssertionError.class);
        new SimplePersistenceImpl(null, null);
        new SimplePersistenceImpl(null, TestEntity.class);
        new SimplePersistenceImpl(manager, null);
    }
    @Test
    public final void testPersist() {
        // case: success
        final TestEntity e01 = new TestEntity();
        ((SimplePersistenceImpl) testee).getManager().getTransaction().begin();
        e01.setName("n01");
        testee.persist(e01);
        ((SimplePersistenceImpl) testee).getManager().getTransaction().commit();
        // case: exception
        thrown.expect(TransactionRequiredException.class);
        testee.persist(e01);
        testee.flush();
    }
    @Test
    public final void testDetach() {
        final TestEntity e01 = new TestEntity();
        LOG.debug("{}", e01);
        testee.persist(e01);
        LOG.debug("{}", e01);
        testee.detach(e01);
        LOG.debug("{}", e01);
    }
    @Test
    public final void testMerge() {
        fail("Not yet implemented"); // TODO
    }
    @Test
    public final void testRemove() {
        fail("Not yet implemented"); // TODO
    }
    @Test
    public final void testFindObject() {
        fail("Not yet implemented"); // TODO
    }
    @Test
    public final void testFindObjectLockModeType() {
        fail("Not yet implemented"); // TODO
    }
}
