package com.pk.DigitalLibrary.service;

import com.pk.DigitalLibrary.entity.Member;
import com.pk.DigitalLibrary.repository.BookRespository;
import com.pk.DigitalLibrary.repository.MemberRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MemberService {

    private MemberRespository memberRespository;

    @Autowired
    public MemberService(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    public Member addmember(Member member) {
        log.info("Adding a new member");
        Member savedMember = this.memberRespository.save(member);
        log.info("New member added : {}",savedMember.getId());
        return savedMember;
    }

    public List<Member> getAllMembers() {
        return this.memberRespository.findAll();
    }

    public Member getMemberByMobile(String mobile){
        return this.memberRespository.findByMobileNumber(mobile).orElse(null);
    }
    public Member getMemberByEmail(String email){
        return this.memberRespository.findByEmail(email).orElse(null);
    }
}
