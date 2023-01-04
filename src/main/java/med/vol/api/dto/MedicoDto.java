package med.vol.api.dto;

import med.vol.api.endereco.DadosEndereco;

public record MedicoDto(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
