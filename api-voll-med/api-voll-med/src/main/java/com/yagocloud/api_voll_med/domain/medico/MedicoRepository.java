package com.yagocloud.api_voll_med.domain.medico;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findAllByAtivoTrue();
}
