// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Test;
/**
 * {@link yoyo.actor.entity}
 * @author nilcy
 */
@SuppressWarnings("all")
public class EntityCreator {
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("primary")
        .createEntityManager();
    @Test
    public void test() {
        assertThat(entityManager, is(not(nullValue())));
    }
}
