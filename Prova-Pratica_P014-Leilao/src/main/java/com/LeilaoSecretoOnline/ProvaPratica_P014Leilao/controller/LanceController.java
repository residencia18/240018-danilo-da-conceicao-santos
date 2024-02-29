package com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.dto.LanceDTO;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.controller.form.LanceForm;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Concorrente;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Lance;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.model.Leilao;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.repository.ConcorrenteRepository;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.repository.LanceRepository;
import com.LeilaoSecretoOnline.ProvaPratica_P014Leilao.repository.LeilaoRepository;


@RestController
@RequestMapping("/lance")
public class LanceController {

    @Autowired
    private LanceRepository lanceRepository;
	@Autowired
    private ConcorrenteRepository concorrenteRepository;
	@Autowired
	private LeilaoRepository leilaoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<LanceDTO> obterLancePorId(@PathVariable Long id) {
        Lance lance = lanceRepository.findById(id).orElse(null);
        if (lance == null) {
            return ResponseEntity.notFound().build();
        }
        LanceDTO lanceDTO = new LanceDTO(lance.getId(), lance.getLeilao(), lance.getConcorrente(), lance.getValor());
        return ResponseEntity.ok(lanceDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<LanceDTO>> listarTodosOsLances() {
        List<Lance> lances = lanceRepository.findAll();
        List<LanceDTO> lancesDTO = lances.stream()
                .map(lance -> new LanceDTO(lance.getId(), lance.getLeilao(), lance.getConcorrente(), lance.getValor()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lancesDTO);
    }
    
    @PostMapping("/")
    public ResponseEntity<LanceDTO> criarLance(@RequestBody LanceForm lanceForm) {
        if (!leilaoRepository.existsById(lanceForm.getLeilao().getId()) || 
            !concorrenteRepository.existsById(lanceForm.getConcorrente().getId())) {
            return ResponseEntity.notFound().build();
        }
        
        Lance lance = lanceForm.criarLance();
        
        lanceRepository.save(lance);
        
        LanceDTO lanceDTO = new LanceDTO(lance.getId(), lance.getLeilao(), lance.getConcorrente(), lance.getValor());
        return ResponseEntity.status(HttpStatus.CREATED).body(lanceDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<LanceDTO> atualizarLance(@PathVariable Long id, @RequestBody LanceForm lanceForm) {
        if (!lanceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        if (!leilaoRepository.existsById(lanceForm.getLeilao().getId()) || 
            !concorrenteRepository.existsById(lanceForm.getConcorrente().getId())) {
            return ResponseEntity.notFound().build();
        }
        
        Lance lance = lanceForm.criarLance();
        lance.setId(id); 
        
        lanceRepository.save(lance);
        
        LanceDTO lanceDTO = new LanceDTO(lance.getId(), lance.getLeilao(), lance.getConcorrente(), lance.getValor());
        return ResponseEntity.ok(lanceDTO);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirLanceID(@PathVariable Long id) {
        Optional<Lance> lanceOptional = lanceRepository.findById(id);

        if (!lanceOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Lance lance = lanceOptional.get();
        Leilao leilao = lance.getLeilao();

        if (!leilao.isStatusAtivo()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        lanceRepository.delete(lance);

        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/")
	public ResponseEntity<LanceDTO> excluirLance() {
			return ResponseEntity.badRequest().build();		
	}

    @GetMapping("/vencedor_leilao/{id}")
    public ResponseEntity<?> obterVencedorLeilao(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Leilao> optionalLeilao = leilaoRepository.findById(id);
        if (optionalLeilao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Leilao leilao = optionalLeilao.get();

        if (!leilao.isStatusAtivo()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Optional<Lance> optionalMaiorLance = lanceRepository.findByLeilaoOrderByValorDesc(leilao);
        if (optionalMaiorLance.isEmpty()) {
            return ResponseEntity.ok("Não há lances para este leilão ainda.");
        }

        Lance maiorLance = optionalMaiorLance.get();
        Concorrente concorrente = maiorLance.getConcorrente();
        double valorMaiorLance = maiorLance.getValor();

        Map<String, Object> response = new HashMap<>();
        response.put("leilao", leilao);
        response.put("concorrente", concorrente);
        response.put("maior_lance", valorMaiorLance);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/vencedor_leilao/")
    public ResponseEntity<?> obterTodosOsVencedoresLeilao() {
        List<Leilao> leiloes = leilaoRepository.findAll();
        List<Map<String, Object>> vencedores = new ArrayList<>();

        for (Leilao leilao : leiloes) {
            if (!leilao.isStatusAtivo()) {
                continue;
            }

            Optional<Lance> optionalMaiorLance = lanceRepository.findByLeilaoOrderByValorDesc(leilao);
            if (optionalMaiorLance.isEmpty()) {
                continue;
            }

            Lance maiorLance = optionalMaiorLance.get();
            Concorrente concorrente = maiorLance.getConcorrente();
            double valorMaiorLance = maiorLance.getValor();

            Map<String, Object> vencedor = new HashMap<>();
            vencedor.put("leilao", leilao);
            vencedor.put("concorrente", concorrente);
            vencedor.put("maior_lance", valorMaiorLance);

            vencedores.add(vencedor);
        }

        if (vencedores.isEmpty()) {
            return ResponseEntity.ok("Não há vencedores de leilão no momento.");
        }

        return ResponseEntity.ok(vencedores);
    }
}
