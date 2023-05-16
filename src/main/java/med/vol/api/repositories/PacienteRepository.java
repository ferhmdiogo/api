package med.vol.api.repositories;

import med.vol.api.model.PacienteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
    Page<PacienteModel> findAllByAtivoTrue(Pageable paginacao);
}
