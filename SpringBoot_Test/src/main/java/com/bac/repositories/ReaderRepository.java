package com.bac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bac.domain.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String> {

}
