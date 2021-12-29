package hello.exception.api;

import hello.exception.exception.UserException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiExceptionController {

    @GetMapping(value = "/api/members/{id}")
    public MemberDto getMember(@PathVariable String id) {
        if (id.equals("ex"))
            throw new RuntimeException("잘못된 사용자");
        if (id.equals("bad"))
            throw new IllegalArgumentException("잘못된 입력 값");
        if (id.equals("user-ex"))
            throw new UserException("사용자 오류");
        return new MemberDto(id, "Hello, " + id);
    }

    @Data
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class MemberDto {
        String memberId;
        String name;
    }

}
