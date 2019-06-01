package br.com.albertoferes.pi.proginternet.repository;

import br.com.albertoferes.pi.proginternet.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
