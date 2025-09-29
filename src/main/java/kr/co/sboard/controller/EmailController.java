package kr.co.sboard.controller;

import kr.co.sboard.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class EmailController {

    private final EmailService emailService;


    @PostMapping("/email/code")
    public ResponseEntity<Map<String, Boolean>> verify(@RequestBody Map<String, Object> jsonData) {
        log.info("code={}", jsonData.get("code"));
        String code = (String) jsonData.get("code");

        boolean result = emailService.verifyCode(code);

        Map<String,Boolean> resultMap = Map.of("isMatched",result);

        return ResponseEntity.ok(resultMap);
    }
}
