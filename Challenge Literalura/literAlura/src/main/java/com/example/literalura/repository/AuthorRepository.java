package com.example.literAlura.repository;

import com.example.literAlura.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    List<AuthorEntity> findByBirthYearBeforeAndDeathYearAfter(int year, int year);
}
