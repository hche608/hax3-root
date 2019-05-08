package integration.me.hax3.h2.embedded;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static shiver.me.timbers.data.random.RandomStrings.buildSomeString;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@SpringBootTest(webEnvironment = NONE)
public class ITEmbeddedH2Gis {

    @Autowired
    private TestRepository repository;


    @Test
    public void Can_use_the_embedded_database() {

        final TestEntity expected = new TestEntity(buildSomeString().withLengthBetween(10, 255).build());

        // Given
        final Long id = repository.save(expected).getId();

        // When
        final TestEntity actual = repository.findById(id).orElse(null);

        // Then
        assertThat(actual, is(expected));
    }


}
