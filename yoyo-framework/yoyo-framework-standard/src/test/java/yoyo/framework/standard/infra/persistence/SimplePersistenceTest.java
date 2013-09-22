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
import org.junit.Test;
/**
 * {@link SimplePersistence}
 * @author nilcy
 */
@SuppressWarnings("all")
public class SimplePersistenceTest {
    private EntityManager manager;
    private SimplePersistence<TestEntity> testee;
    @Before
    public void setUp() throws Exception {
        manager = Persistence.createEntityManagerFactory("primary").createEntityManager();
        testee = new SimplePersistence(manager, TestEntity.class);
        // testee.getManager().getTransaction().begin();
    }
    @After
    public void tearDown() throws Exception {
        // testee.getManager().getTransaction().rollback();
    }
    @Test
    public final void testSimplePersistence() {
        assertThat(new SimplePersistence(manager, TestEntity.class), is(not(nullValue())));
    }
    @Test
    public final void testPersist() {
        final TestEntity e01 = new TestEntity();
        {
            testee.getManager().getTransaction().begin();
            e01.setName("n01");
            testee.persist(e01);
            testee.getManager().getTransaction().commit();
        }
        try {
            testee.persist(e01);
            testee.flush();
            fail();
        } catch (final TransactionRequiredException e) {
        }
        testee.getManager().getTransaction().begin();
        testee.persist(e01);
        testee.flush();
    }
    @Test
    public final void testDetach() {
        final TestEntity e01 = new TestEntity();
        testee.persist(e01);
        testee.detach(e01);
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
