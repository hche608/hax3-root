package unit.me.hax3.acceptance.step;

import me.hax3.acceptance.step.GenericHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static shiver.me.timbers.data.random.RandomThings.someThing;

class GenericHolderTest {

  private GenericHolder<Object> holder;

  @BeforeEach
  void setUp() {
    holder = new GenericHolder<>();
  }

  @Test
  void Can_set_a_value() {

    final Object expected = someThing();

    // Given
    holder.set(expected);

    // When
    final Object actual = holder.get();

    // Then
    assertThat(actual, is(expected));
  }

  @Test
  void Generic_holder_has_to_string() {

    final Object value = someThing();

    // Given
    holder.set(value);

    // When
    final String actual = holder.toString();

    // Then
    assertThat(actual, containsString(value.toString()));
  }
}
