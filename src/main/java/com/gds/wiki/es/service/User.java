package com.gds.wiki.es.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by wiki on 2020/7/20 13:16
 */
@Data
@NoArgsConstructor
@Document(indexName = "user")
public class User {
    private Long id;

    private String name;

    private String like;

    private Integer age;

    private String address;
}
