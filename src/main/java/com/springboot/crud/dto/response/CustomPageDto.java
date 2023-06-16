package com.springboot.crud.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomPageDto {

    Long totalElements;

    int totalPages;

    int number;

    int size;
}