package med.vol.api.controller;

import med.vol.api.dto.MedicoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/medicos")
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody MedicoDto medico){
        System.out.println(medico);

    }
}
