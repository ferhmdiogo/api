package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.dto.DadosAtualizacaoMedico;
import med.vol.api.dto.DadosListar;
import med.vol.api.dto.MedicoDto;
import med.vol.api.model.MedicoModel;
import med.vol.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public void cadastrar(@RequestBody @Valid MedicoDto dados){
        repository.save(new MedicoModel(dados));

    }

    @GetMapping
    public Page<DadosListar> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListar::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){

    }
}
