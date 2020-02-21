package autoservice;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Component
public class RegistrationValidator implements Predicate<String> {

    private static final Predicate<String> IS_VALID =
            Pattern.compile("\\D\\D\\d\\d\\D\\D\\D", Pattern.CASE_INSENSITIVE)
                    .asPredicate();

    @Override
    public boolean test(String registration) {
        return IS_VALID.test(registration);
    }
}
