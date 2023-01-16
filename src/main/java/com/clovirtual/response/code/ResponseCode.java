package com.clovirtual.response.code;

import org.springframework.http.HttpStatus;

/**
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */
public interface ResponseCode {
  String getMessage();

  String getCode();

  int getStatusCode();

  HttpStatus getHttpStatus();

  static ResponseCode getEnumByCodeValue(String codeValue, ResponseCode[] values) {
    ResponseCode[] var2 = values;
    int var3 = values.length;

    for(int var4 = 0; var4 < var3; ++var4) {
      ResponseCode e = var2[var4];
      if (e.getCode().equals(codeValue)) {
        return e;
      }
    }

    throw new IllegalArgumentException("Your code value is not valid.>>>>" + codeValue);
  }
}
