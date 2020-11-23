package com.example.sqlinject.Controller;

import com.example.sqlinject.Service.SqlService;
import com.example.sqlinject.domain.Domain;
import com.example.sqlinject.key.RandomKeyGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class SqlController {  //이부분에 반환할 조건 써주기

        @Autowired
        private SqlService sqlService;

        @RequestMapping
        @ResponseBody
        public void InsertList(Domain domain) throws Exception {

            RandomKeyGenerator rkg = new RandomKeyGenerator();

            domain.setMSGID(rkg.nextSeqNumberKey());
            sqlService.InsertList(domain);
        }

   /** @RequestMapping(value = "/list/{id}", method=RequestMethod.GET)
    @ResponseBody() // JSON
    public Map<String, String> home(@PathVariable String id) {

        Map<String, String> list = new HashMap<>();

        list.put("id", id);
        list.put("pw", "codevang123");
        list.put("location", "SEOUL");

        return list;
    }

*/


    }





