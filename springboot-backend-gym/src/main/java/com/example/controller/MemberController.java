package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Entity.Member;
import com.example.Exception.ResourceNotfoundException;
import com.example.repository.MemberRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") Long id)
            throws ResourceNotfoundException {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfoundException("Member not found for this id :: " + id));
        return ResponseEntity.ok().body(member);
    }

    @PostMapping("/members")
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable(value = "id") Long id,
            @RequestBody Member memberDetails) throws ResourceNotfoundException {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfoundException("Member not found with this id :: " + id));

        member.setName(memberDetails.getName());
        member.setAddress(memberDetails.getAddress());
        member.setPhone(memberDetails.getPhone());
        member.setJoinDate(memberDetails.getJoinDate());
        member.setPrice(memberDetails.getPrice());
        member.setMembership(memberDetails.getMembership());
        member.setTrainer(memberDetails.getTrainer()); // Added this line

        final Member updatedMember = memberRepository.save(member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/members/{id}")
    public Map<String, Boolean> deleteMember(@PathVariable(value = "id") Long id)
            throws ResourceNotfoundException {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotfoundException("Member not found with this id :: " + id));

        memberRepository.delete(member);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Member with this id "+id+" is deleted", Boolean.TRUE);
        return response;
    }
}
