package com.example.literalura.repository;

import com.example.literAlura.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByLanguage(String language);
}
