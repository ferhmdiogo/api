package med.vol.api.dto;

import med.vol.api.model.MedicoModel;

public record DadosListar(Long id, String nome, String crm, String email, Especialidade especialidade) {

    public DadosListar(MedicoModel medicoModel) {
        this(medicoModel.getId(), medicoModel.getNome(), medicoModel.getCrm(), medicoModel.getEmail(), medicoModel.getEspecialidade());
    }

}
