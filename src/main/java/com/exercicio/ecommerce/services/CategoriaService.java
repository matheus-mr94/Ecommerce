package com.exercicio.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.ecommerce.mappers.CategoriaMapper;
import com.exercicio.ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaMapper categoriaMapper;
	
	@Autowired
	CategoriaRepository categoriaRepository;

}
