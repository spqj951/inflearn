package com.kyujin.kyujinshop.controller;

import com.kyujin.kyujinshop.repository.MemberRepository;
import com.kyujin.kyujinshop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //field injection
    @Autowired
    private MemberService memberService;

    //constructor injection == the best
//    @Autowired
//    public MemberController(MemberService memberService){
//        this.memberSerivce = memberService;
//    }

    //setter injection
    //anyone can get this
    public void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }


}
