package com.sbb.flexrate.controller;

import com.sbb.flexrate.domain.Credit;
import com.sbb.flexrate.dto.CreditCreateRequestDto;
import com.sbb.flexrate.dto.CreditInfoDto;
import com.sbb.flexrate.member.MemberRepository;
import com.sbb.flexrate.member.Member;
import com.sbb.flexrate.exception.DataNotFoundException;
import com.sbb.flexrate.service.CreditService;
import com.sbb.flexrate.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditController {
    private final CreditService creditService;

    /*
    //get method 매핑
    @GetMapping("/{memberId}")
    public ResponseEntity<?> getCreditByMemberId(@PathVariable Long memberId){
        try {
            return ResponseEntity.ok(creditService.findMyCredit(memberId));
        }catch (DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
*/
    /*
    @PostMapping("/create")
    public ResponseEntity<Credit> createCredit(@RequestBody CreditCreateRequestDto creditDto){
        //        Optional<Credit> existingCredit =

        if (existingCredit.isPresent()) {
            // Credit이 이미 존재하는 경우 예외 발생
            throw new CreditAlreadyExistsException("credit이 이미 존재합니다");
        }

        Credit credit=creditService.createcredit(creditDto);
        return ResponseEntity.ok(credit);
    }
   */
/*
    @PostMapping("/create")
    public ResponseEntity<CreditCreateRequestDto> postCredit(){

    }

 */

    @GetMapping("/{memberId}")
    public ResponseEntity<CreditInfoDto> getCreditInfo(@PathVariable("memberId") Long memberId){
        try {
            CreditInfoDto creditInfoDto=creditService.getCreditInfo(memberId);
            return ResponseEntity.ok(creditInfoDto);
        }catch (DataNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<?> updateCredit(@PathVariable Long memberId, @RequestBody CreditCreateRequestDto creditDto){
        try {
            creditService.updateCredit(memberId,creditDto);
            return ResponseEntity.ok("Credit 업데이트 성공");
        }catch (DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}