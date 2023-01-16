
package com.clovirtual.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PagingRequestParam {

  private final int page;

  private final int pageSize;

  private final String keyword;
}
