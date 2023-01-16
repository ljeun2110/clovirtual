package com.clovirtual.processor;

import com.clovirtual.dto.EmployeeDto;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Component;

/**
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */

@Component
public class EmployeeMemoryProcessor {

  private final AtomicReference<List<EmployeeDto>> caches = new AtomicReference<>(new ArrayList<>());

  public List<EmployeeDto> read() {
    return caches.get();
  }

  public void write(List<EmployeeDto> employeeDtos) {
    var list = caches.get();
    list.addAll(employeeDtos);
    caches.getAndSet(list);
  }
}

