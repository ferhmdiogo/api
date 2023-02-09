package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.dto.DadosAtualizacaoMedico;
import med.vol.api.dto.DadosDetalhamentoMedico;
import med.vol.api.dto.DadosListar;
import med.vol.api.dto.MedicoDto;
import med.vol.api.model.MedicoModel;
import med.vol.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid MedicoDto dados){
        var medico= repository.save(new MedicoModel(dados));

        return ResponseEntity.created(new MedicoModel(HttpStatus.CREATED));

    }

    @GetMapping
    public ResponseEntity <Page<DadosListar>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListar::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarinformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();

    }
}
