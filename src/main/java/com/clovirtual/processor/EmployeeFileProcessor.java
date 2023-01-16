package com.clovirtual.processor;

import com.clovirtual.dto.EmployeeDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */
@RequiredArgsConstructor
@Component
public class EmployeeFileProcessor {
  @Value("classpath:/WEB-INF/data.txt")
  private Resource resource;

  @Autowired
  private ResourceLoader resourceLoader;

  private final ObjectMapper objectMapper;

  public List<EmployeeDto> read() {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(resource.getFile()), StandardCharsets.UTF_8))) {

      var result = "";
      String line;
      while ((line = br.readLine()) != null) {

        result += line;
      }

      return objectMapper.readValue(result, new TypeReference<List<EmployeeDto>>() {
      });
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void save(List<EmployeeDto> employeeDtos) {
    var list = read();
    list.addAll(employeeDtos);

    Resource resource = resourceLoader.getResource("classpath:/WEB-INF/data.txt");
    try(var fos = new FileOutputStream(resource.getFile())) {
      var jsonStr = objectMapper.writeValueAsString(list);
      byte[] inputs = jsonStr.getBytes();
      fos.write(inputs);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

