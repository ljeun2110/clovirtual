package com.clovirtual.repository;

import com.clovirtual.dto.EmployeeDto;
import com.clovirtual.dto.PagingRequestParam;
import java.io.IOException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryImplTest {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Test
  public void test() throws IOException {
    var newEmployee = new EmployeeDto();
    newEmployee.setName("이지은");
    newEmployee.setEmail("jjj@naver.com");
    newEmployee.setTel("010-0000-0000");
    newEmployee.setJoined("2022-02-02");
    employeeRepository.saveAll(Arrays.asList(newEmployee));
  }

  @Test
  public void readOperations() {
    var list = employeeRepository.list(new PagingRequestParam(1, 3, ""));
    list.forEach(System.out::println);
  }
}