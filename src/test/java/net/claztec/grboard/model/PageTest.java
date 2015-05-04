package net.claztec.grboard.model;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Null;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Derek Choi on 15. 5. 4.
 */
public class PageTest {

//    Link: <https://blog.mwaysolutions.com/sample/api/v1/cars?offset=15&limit=5>; rel="next",
//    <https://blog.mwaysolutions.com/sample/api/v1/cars?offset=50&limit=3>; rel="last",
//    <https://blog.mwaysolutions.com/sample/api/v1/cars?offset=0&limit=5>; rel="first",
//    <https://blog.mwaysolutions.com/sample/api/v1/cars?offset=5&limit=5>; rel="prev",

    @Test
    public void testFirstPaging() {
        int totalRowCount = 100079;
        int offset = 0;
        int limit = 10;
        Page page = new Page(offset, limit);
        page.setTotalItemCount(totalRowCount);
        assertTrue(page.hasPrevious());
        assertFalse(page.hasNext());
        assertThat(page.next(), is(0));
        assertThat(page.previous(), is(10));
    }

    @Test
    public void testLastPaging() {
        int totalRowCount = 100079;
        int offset = 100070;
        int limit = 10;
        Page page = new Page(offset, limit);
        page.setTotalItemCount(totalRowCount);
        assertFalse(page.hasPrevious());
        assertTrue(page.hasNext());
        assertThat(page.next(), is(100060));
        assertThat(page.previous(), is(100070));
    }

}
