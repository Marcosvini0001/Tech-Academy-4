package com.gympoison.projeto_tech.repository;

import com.gympoison.projeto_tech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
