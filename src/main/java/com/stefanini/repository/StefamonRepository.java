package com.stefanini.repository;


import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Stefamon;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class StefamonRepository extends GenericDAO<Stefamon, Long> {
}
