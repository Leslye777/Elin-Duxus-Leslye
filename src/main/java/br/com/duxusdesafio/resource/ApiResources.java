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

    @GetMapping("/time-da-data")
    public ResponseEntity<TimeDataDTO> timeDaData(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {

        List<Time> times = apiService.todosOsTimes();
        TimeDataDTO time = apiService.timeDaData(data, times);

        if (time != null) {
            return new ResponseEntity<>(time, HttpStatus.OK);
        } else {
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

    @GetMapping("/time-mais-comum")
    public ResponseEntity<List<String>> timeMaisComum(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
    ) {
        // Suponha que você já tenha uma lista preenchida de times
        List<Time> times = apiService.todosOsTimes();

        // Chame a função timeMaisComum
        List<String> timeMaisComum = apiService.timeMaisComum(dataInicial, dataFinal, times);

        if (!timeMaisComum.isEmpty()) {
            return new ResponseEntity<>(timeMaisComum, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/funcao-mais-comum")
    public ResponseEntity<String> funcaoMaisComum(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal
    ) {
        List<Time> times = apiService.todosOsTimes();
        String funcaoMaisComum = apiService.funcaoMaisComum(dataInicial, dataFinal, times);

        if (funcaoMaisComum != null ) {
            return new ResponseEntity<>(funcaoMaisComum, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
