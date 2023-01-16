package com.clovirtual.response;

import com.clovirtual.response.code.ResponseCode;
import com.clovirtual.response.code.SuccessResponseCode;

/**
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */
public class ResponseCreated<T> extends ResponseData<T> {
  public ResponseCreated(String message) {
    super(SuccessResponseCode.CREATED, message, null);
  }

  public ResponseCreated(String message, T data) {
    super(SuccessResponseCode.CREATED, message, data);
  }

  private ResponseCreated(ResponseCode responseCode, String message, T data) {
    super(responseCode, message, data);
  }

  public String toString() {
    return "ResponseCreated(super=" + super.toString() + ")";
  }
}
