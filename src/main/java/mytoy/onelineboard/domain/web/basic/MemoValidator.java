package mytoy.onelineboard.domain.web.basic;

import mytoy.onelineboard.domain.board.Memo;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MemoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Memo.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(Object target, Errors errors) {
        Memo memo= (Memo) target;

        //검증 로직
        if (!StringUtils.hasText(memo.getUsername())){
            errors.rejectValue("username", "required");
        }
        if (!StringUtils.hasText(memo.getTitle())){
            errors.rejectValue("title", "required");
        }
        if (!StringUtils.hasText(memo.getText())){
            errors.rejectValue("text", "required");
        }

    }
}
