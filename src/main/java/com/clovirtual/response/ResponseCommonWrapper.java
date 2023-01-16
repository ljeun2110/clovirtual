package com.clovirtual.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.http.ResponseEntity;

/**
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */
public class ResponseCommonWrapper<T> extends ResponseEntity<ResponseData<T>> {
  @JsonCreator
  public ResponseCommonWrapper(ResponseData<T> body) {
    super(body, body.getResponseCode().getHttpStatus());
  }

  public T getData() {
    return (T) ((ResponseData)this.getBody()).getData();
  }
}


