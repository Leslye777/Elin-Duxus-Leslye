package br.com.duxusdesafio.resource;

import br.com.duxusdesafio.dto.TimeDataDTO;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ApiResources {

    @Autowired
    private ApiService apiService;

    @GetMapping
    public ResponseEntity<TimeDataDTO> timeDaData(@RequestBody LocalDate data) {

        TimeDataDTO time = apiService.timeDaData(data);

        if(time != null) {
            return new ResponseEntity<>(time, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
