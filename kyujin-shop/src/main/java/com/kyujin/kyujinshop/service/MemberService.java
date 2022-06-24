package com.kyujin.kyujinshop.service;

import com.kyujin.kyujinshop.domain.Member;
import com.kyujin.kyujinshop.repository.MemberRepository;
import com.kyujin.kyujinshop.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;



    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /*
    * sign up
    * */

    public Long join(Member member){

        validateDuplilcateMember(member);//중복막기


        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplilcateMember(Member member) {
        memberRepository.findByName(member.getName())
             .ifPresent(m -> {
             throw new IllegalStateException("이미 존재하는 회원입니다.");
         });
    }
    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
