package com.clovirtual.repository;

import com.clovirtual.dto.EmployeeDto;
import com.clovirtual.dto.PagingRequestParam;
import com.clovirtual.processor.EmployeeFileProcessor;
import com.clovirtual.processor.EmployeeMemoryProcessor;
import com.clovirtual.response.ResponseCommonWrapper;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */
@RequiredArgsConstructor
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
  private final EmployeeFileProcessor processor;

  private final EmployeeMemoryProcessor memoryProcessor;

  private ReentrantLock reentrantLock = new ReentrantLock();

  @PostConstruct
  public void init() {
    var employees = processor.read();
    memoryProcessor.write(employees);
  }

  @Override
  public List<Long> saveAll(List<EmployeeDto> employeeDtos) throws IOException {
    try {
      reentrantLock.lock();
      processor.save(employeeDtos);
    } finally {
      reentrantLock.unlock();
    }
    return null;
  }

  @Override
  public void save(EmployeeDto employeeDto) {
    try {
      reentrantLock.lock();
      processor.save(Arrays.asList(employeeDto));
    } finally {
      reentrantLock.unlock();
    }
  }

  @Override
  public Long countEmployee(String keyword) {
    return null;
  }

  @Override
  public List<EmployeeDto> list(PagingRequestParam request) {
    var list = memoryProcessor.read();
    if (request.getKeyword() != null && request.getKeyword() != "") {
      return list.stream()
          .filter(x -> request.getKeyword().equals(x.getName()))
          .collect(Collectors.toList());
    }
    int prev = request.getPage() * request.getPageSize();
    int next = (request.getPage() + 1) * request.getPageSize();

    if (next > list.size()) {
      next = list.size();
    }

    return IntStream.range(prev, next)
        .boxed()
        .map(list::get)
        .collect(Collectors.toList());
  }

  @Override
  public ResponseCommonWrapper findByName(String name) {
    return null;
  }
}

