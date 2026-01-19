package com.rashmier.employee.demo.service;

import java.util.List;

import com.rashmier.employee.demo.controller.api.CustomApiResponse;

public interface BaseCRUDService<D, ID, P> {

    CustomApiResponse<D> create(D dto);

    CustomApiResponse<D> findById(ID id);

    CustomApiResponse<List<D>> findAll();

    CustomApiResponse<D> update(ID id, D dto);

    CustomApiResponse<Void> delete(ID id);
    
    CustomApiResponse<D> patch(ID id, P dto);
}
