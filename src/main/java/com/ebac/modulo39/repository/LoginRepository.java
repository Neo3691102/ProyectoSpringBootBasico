package com.ebac.modulo39.repository;

import com.ebac.modulo39.dto.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
