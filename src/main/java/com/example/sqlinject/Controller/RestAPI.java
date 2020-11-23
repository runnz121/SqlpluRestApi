package com.example.sqlinject.Controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping
public class RestAPI {


    @PostMapping("/result")
    public MultiValueMap<String, String> request (@RequestParam (value = "MSGID", required = false) String MSGID) {

        String url = "http://localhost:8080";


        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        ResponseEntity<String> res = new RestTemplate().postForEntity(url, parameters, String.class);

        parameters.add("MSGID", MSGID);

        System.out.println(res.getBody());
        System.out.println(res.getStatusCodeValue());
        return parameters;







    /**parameters.add("REQDT", Domain.getREQDT());
    parameters.add("RESDT", Domain.getRESDT());
    parameters.add("PATCHTNUM", Domain.getPATCHTNUM());
    parameters.add("WORKID", Domain.getWORKID());
    parameters.add("WORKCATEGORY", Domain.getWORKCATEGORY());
    parameters.add("REQID", Domain.getREQID());
    parameters.add("REQIP", Domain.getREQIP());*/








    }
}




 // 참조 코드 https://sosimhan-dev.tistory.com/3
      //https://qastack.kr/programming/38372422/how-to-post-form-data-with-spring-resttemplate
      //https://shlee0882.tistory.com/249
      //https://hongku.tistory.com/120?category=799261







