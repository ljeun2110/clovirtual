package com.clovirtual.api;

import com.clovirtual.dto.EmployeeDto;
import com.clovirtual.dto.EmployeeResponse;
import com.clovirtual.dto.PagingRequestParam;
import com.clovirtual.response.ResponseCommonWrapper;
import com.clovirtual.response.ResponseCreated;
import com.clovirtual.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeApi {
  private final EmployeeService employeeService;

  /**
   * employee를 조회
   *
   * @return {@link ResponseCommonWrapper}
   */
  @GetMapping("/")
  public List<EmployeeDto> list(
      PagingRequestParam request
  ) {
      return employeeService.list(request);
  }

  /**
   * employee를 이름으로 조회합니다.
   *
   * @param name 이름
   * @return {@link ResponseCommonWrapper}
   */
  @GetMapping("/{name}")
  public ResponseCommonWrapper<EmployeeResponse> findByName(
      @PathVariable String name
  ) {
      return employeeService.findByName(name);
  }


  @PostMapping(value = "")
  public ResponseCommonWrapper<Void> createEmployee(
      @RequestBody EmployeeDto request
  ) {
    employeeService.create(request);

    return new ResponseCommonWrapper<>(
        new ResponseCreated<>("Success create employee.")
    );
  }
}
