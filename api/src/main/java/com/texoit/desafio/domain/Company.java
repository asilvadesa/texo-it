package com.texoit.desafio.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
