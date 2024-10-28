package com.pk.DigitalLibrary.controller;

import com.pk.DigitalLibrary.entity.Member;
import com.pk.DigitalLibrary.repository.BookRespository;
import com.pk.DigitalLibrary.repository.MemberRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

    private MemberRespository memberRespository;

    @Autowired
    public MemberController(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    @PostMapping("/addMember")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
     Member savedMember = this.memberRespository.save(member);
     return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> members = this.memberRespository.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("mobile/{mobile}")
    public ResponseEntity<Member> getMemberByMobile(@PathVariable String mobile) {
        Member member = this.memberRespository.findByMobileNumber(mobile).orElse(null);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<Member> getMemberByEmail(@PathVariable String email) {
        Member member = this.memberRespository.findByEmail(email).orElse(null);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }


}
