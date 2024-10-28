package com.pk.DigitalLibrary.repository;

import com.pk.DigitalLibrary.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRespository extends JpaRepository<Member, UUID> {

    //to get a member by mobile
   Optional<Member> findByMobileNumber(String mobileNumber);

   Optional<Member> findByEmail(String email);

}
