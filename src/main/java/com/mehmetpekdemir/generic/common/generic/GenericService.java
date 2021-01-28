package com.mehmetpekdemir.generic.common.generic;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface GenericService<Response, CreateRequest, UpdateRequest> {

    Response findById(Long id);

    List<Response> findAll();

    List<Response> findPaginated(Pageable pageable);

    Response create(CreateRequest createRequest);

    Response update(UpdateRequest updateRequest);

    void deleteById(Long id);

}
