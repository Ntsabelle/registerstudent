package student.Validator;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Component
public class PhoneValidator implements Predicate<String> {

    private static final Predicate<String> IS_PHONE_VALID =
            Pattern.compile(
                    "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$",
                    Pattern.CASE_INSENSITIVE
            ).asPredicate();

    @Override
    public boolean test(String phone) {
        return IS_PHONE_VALID.test(phone);
    }
}
