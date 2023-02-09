package med.vol.api.dto;

import med.vol.api.model.PacienteModel;

public record DadosListagemPaciente(Long id, String nome, String email, String cpf) {

    public DadosListagemPaciente(PacienteModel paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
