package autoservice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegistrationValidatorTest {

    private final RegistrationValidator underTest = new RegistrationValidator();

    @Test
    public void validate() {
        assertThat(underTest.test("CK16CIF")).isTrue();
    }

    @Test
    public void validate2() {
        assertThat(underTest.test("C116CIF")).isFalse();
    }

    @Test
    public void validate3() {
        assertThat(underTest.test("CKF6CIF")).isFalse();
    }

    @Test
    public void validate4() {
        assertThat(underTest.test("CKF6CIFS")).isFalse();
    }

    @Test
    public void validate5() {
        assertThat(underTest.test("CKF6CIFS1")).isFalse();
    }
}