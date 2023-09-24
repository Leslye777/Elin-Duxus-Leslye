package br.com.duxusdesafio.resource;

import br.com.duxusdesafio.dto.TimeDataDTO;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ApiResources {

    @Autowired
    private ApiService apiService;

    @GetMapping
    public ResponseEntity<TimeDataDTO> timeDaData(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate data) {

        List<Time> times = apiService.todosOsTimes();
        TimeDataDTO time = apiService.timeDaData(data, times);

        if(time != null) {
            return new ResponseEntity<>(time, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/integrante-mais-usado")
    public ResponseEntity<Integrante> integranteMaisUsado(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
    ) {
        List<Time> times = apiService.todosOsTimes();
        Integrante integrante = apiService.integranteMaisUsado(dataInicial, dataFinal, times);

        if (integrante != null) {
            return new ResponseEntity<>(integrante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
