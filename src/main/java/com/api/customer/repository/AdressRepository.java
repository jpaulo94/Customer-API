package com.api.customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.customer.model.Adress;

public interface AdressRepository extends JpaRepository<Adress, Long>{
	
	Optional<List<Adress>> findByDocumentId(Long id);

}
