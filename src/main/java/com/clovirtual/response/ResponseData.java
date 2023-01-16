package com.clovirtual.response;

import com.clovirtual.response.code.ResponseCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.NonNull;

/**
 *
 * <p> ResponseData. </p>
 *
 * @author Jieun Lee
 * @version 1.0
 * @since 1.0
 */
public class ResponseData<T> {
  private ResponseCode responseCode;
  private String message;
  @JsonInclude(Include.NON_NULL)
  private T data;

  public ResponseData(@NonNull ResponseCode responseCode, @NonNull String message, T data) {
    if (responseCode == null) {
      throw new NullPointerException("responseCode is marked non-null but is null");
    } else if (message == null) {
      throw new NullPointerException("message is marked non-null but is null");
    } else {
      this.responseCode = responseCode;
      this.message = message;
      this.data = data;
    }
  }

  public ResponseData(@NonNull ResponseCode responseCode, T data) {
    if (responseCode == null) {
      throw new NullPointerException("responseCode is marked non-null but is null");
    } else {
      this.responseCode = responseCode;
      this.message = responseCode.getMessage();
      this.data = data;
    }
  }

  public ResponseCode getResponseCode() {
    return this.responseCode;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public String toString() {
    ResponseCode var10000 = this.getResponseCode();
    return "ResponseData(responseCode=" + var10000 + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
  }

  protected ResponseData() {
  }

  void setData(final T data) {
    this.data = data;
  }
}


