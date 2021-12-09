package com.example.jungle.service;

import com.example.jungle.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


class MemberServiceTest {

    MemberService memberService;

    public MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    void joinTest() {
        //given
        Member member = new Member();
        member.setName("아이디");
        //when
        Long saveID = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveID).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void duplicateJoinTest() {
        Member member = new Member();
        member.setName("spring");

        Member member1 = new Member();
        member1.setName("spring");

        memberService.join(member);
        assertThrows(IllegalStateException.class, () -> memberService.join(member1));


    }

    @Test
    void findMembersTest() {
    }

    @Test
    void findOneTest() {
    }
}