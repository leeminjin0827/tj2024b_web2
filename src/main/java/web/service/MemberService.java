package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

import java.lang.reflect.Member;

@Service // 해당 클래스가 서비스임을 주입
@RequiredArgsConstructor // final 필드에 대해서 @Autowired 주입 생략 해도 된다.
public class MemberService {

    private final MemberMapper memberMapper;

    // [1] 회원가입
    public boolean signUp( MemberDto memberDto ){
        System.out.println("MemberService.signUp");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberMapper.signUp( memberDto );
        System.out.println("result = " + result);
        return result;
    } // f end

    // [2] 로그인
    public MemberDto login(MemberDto memberDto ){
        System.out.println("MemberService.login");
        System.out.println("memberDto = " + memberDto);
        MemberDto result = memberMapper.login( memberDto );
        System.out.println("result = " + result);
        return result;
    } // f end

} // c end
