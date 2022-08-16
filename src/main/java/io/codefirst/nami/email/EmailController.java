package io.codefirst.nami.email;

import io.codefirst.nami.app.NamiConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(NamiConstant.API_PREFIX + "/mail")
record EmailController(EmailClient emailClient) {

    @GetMapping("/send")
    void send(EmailDetails emailDetails) {
        emailClient.sendSimpleMail(emailDetails);
    }
}
