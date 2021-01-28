package com.mehmetpekdemir.generic.common.generic;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface GenericController<Response, CreateRequest, UpdateRequest> {

    @GetMapping("/{id}")
    ResponseEntity<Response> findById(@PathVariable(name = "id") Long id);

    @GetMapping
    ResponseEntity<List<Response>> findAll();

    @GetMapping("/paginate")
    ResponseEntity<List<Response>> findPaginated(Pageable pageable);

    @PostMapping
    ResponseEntity<Response> create(@Valid @RequestBody CreateRequest createRequest);

    @PutMapping
    ResponseEntity<Response> update(@Valid @RequestBody UpdateRequest updateRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id);

}
