package com.clovirtual.response.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

/**
 *
 * <p> 클래스 설명 </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */
public enum SuccessResponseCode implements ResponseCode {
  OK(200, "S00", "OK", HttpStatus.OK),
  CREATED(201, "S01", "CREATED", HttpStatus.CREATED),
  ACCEPTED(202, "S02", "ACCEPTED", HttpStatus.ACCEPTED),
  NO_CONTENT(204, "S03", "NO CONTENT", HttpStatus.NO_CONTENT);

  private final int statusCode;
  private final String code;
  private final String message;
  @JsonIgnore
  private final HttpStatus httpStatus;

  @JsonCreator
  private SuccessResponseCode(int statusCode, String code, String message, HttpStatus httpStatus) {
    this.statusCode = statusCode;
    this.code = code;
    this.message = message;
    this.httpStatus = httpStatus;
  }

  public static SuccessResponseCode getEnumByCodeValue(String code) {
    return (SuccessResponseCode)ResponseCode.getEnumByCodeValue(code, values());
  }

  public String toString() {
    String var10000 = this.name();
    return "SuccessResponseCode." + var10000 + "(statusCode=" + this.getStatusCode() + ", code=" + this.getCode() + ", message=" + this.getMessage() + ", httpStatus=" + this.getHttpStatus() + ")";
  }

  public int getStatusCode() {
    return this.statusCode;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public HttpStatus getHttpStatus() {
    return this.httpStatus;
  }
}
