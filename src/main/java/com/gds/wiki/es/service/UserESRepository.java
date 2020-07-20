package com.gds.wiki.es.service;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by wiki on 2020/7/20 13:37
 */
public interface UserESRepository extends ElasticsearchRepository<User, Long> {
}
