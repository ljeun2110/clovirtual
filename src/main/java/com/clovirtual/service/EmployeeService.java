package com.clovirtual.service;

import com.clovirtual.dto.EmployeeDto;
import com.clovirtual.dto.PagingRequestParam;
import com.clovirtual.repository.EmployeeRepository;
import com.clovirtual.response.ResponseCommonWrapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * <p> service. </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeService {

  private final EmployeeRepository repository;

  public Long countEmployee(String keyword) {
    return repository.countEmployee(keyword);
  }

  public ResponseCommonWrapper findByName(String name) {
    return repository.findByName(name);
  }

  public void create(EmployeeDto request) {
    repository.save(request);
  }

  public List<EmployeeDto> list(PagingRequestParam request) {
    return repository.list(request);
  }
}

