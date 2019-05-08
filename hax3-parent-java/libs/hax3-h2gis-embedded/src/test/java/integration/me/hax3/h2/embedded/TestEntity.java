package integration.me.hax3.h2.embedded;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class TestEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String value;

    TestEntity() {
    }

    public TestEntity(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, value);
    }
}
