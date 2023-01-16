
package com.clovirtual.repository;

import com.clovirtual.dto.EmployeeDto;
import com.clovirtual.dto.PagingRequestParam;
import com.clovirtual.response.ResponseCommonWrapper;
import java.io.IOException;
import java.util.List;

/**
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */
public interface EmployeeRepository {

  List<Long> saveAll(List<EmployeeDto> employeeDto) throws IOException;
  void save(EmployeeDto employeeDto);
  Long countEmployee(String keyword);

  List<EmployeeDto> list(PagingRequestParam request);

  ResponseCommonWrapper findByName(String name);

//  Page<EmployeeDto> findAggregate();
}

