package com.kyujin.kyujinshop;

import com.kyujin.kyujinshop.repository.MemberRepository;
import com.kyujin.kyujinshop.repository.MemoryMemberRepository;
import com.kyujin.kyujinshop.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
