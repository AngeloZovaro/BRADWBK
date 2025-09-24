package br.edu.ifsp.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DroidInput {
    private String id;
    private String name;
    private String primaryFunction;
}