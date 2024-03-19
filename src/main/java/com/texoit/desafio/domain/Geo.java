package com.texoit.desafio.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Geo {
    private String lat;
    private String lng;
}
