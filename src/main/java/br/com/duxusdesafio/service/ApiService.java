package br.com.duxusdesafio.service;

import br.com.duxusdesafio.dto.TimeDataDTO;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * @author carlosau
 */
@Service
public class ApiService {

    @Autowired
    private TimeRepository timeRepository;


    public List<Time> todosOsTimes(){
        return timeRepository.findAll();
    }


    /**
     * Vai retornar uma lista com os nomes dos integrantes do time daquela data
     */
    public TimeDataDTO timeDaData(LocalDate data, List<Time> todosOsTimes) {


        List<String> integrantes = todosOsTimes.stream()
                .filter(time -> time.getData().isEqual(data))
                .flatMap(time -> time.getComposicaoTime().stream())
                .map(composicao -> composicao.getIntegrante().getNome())
                .collect(Collectors.toList());

        TimeDataDTO timeData = new TimeDataDTO();
        timeData.setData(data);
        timeData.setIntegrantes(integrantes);

        return timeData;
    }



    /**
     * Vai retornar o integrante que tiver presente na maior quantidade de times
     * dentro do período
     */
    public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {

        Map<Integrante, Long> integranteContagem = todosOsTimes.stream()
                .filter(time -> time.getData().isAfter(dataInicial) || time.getData().isEqual(dataInicial))
                .filter(time -> time.getData().isBefore(dataFinal) || time.getData().isEqual(dataFinal))
                .flatMap(time -> time.getComposicaoTime().stream())
                .collect(Collectors.groupingBy(
                        ComposicaoTime::getIntegrante,
                        Collectors.counting()
                ));

        // Procura o integrante com a contagem mais alta
        Map.Entry<Integrante, Long> entry = integranteContagem.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElse(null);

        if (entry != null) {
            return entry.getKey();
        } else {
            return null; // Retorna null se não houver integrantes dentro do período
        }

    }

    /**
     * Vai retornar uma lista com os nomes dos integrantes do time mais comum
     * dentro do período
     */
    public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar a função mais comum nos times dentro do período
     */
    public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
        // TODO Implementar método seguindo as instruções!
        return null;
    }


    /**
     * Vai retornar o nome da Franquia mais comum nos times dentro do período
     */
    public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

    /**
     * Vai retornar o número (quantidade) de Funções dentro do período
     */
    public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
        // TODO Implementar método seguindo as instruções!
        return null;
    }

}
