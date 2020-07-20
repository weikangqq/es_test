package com.gds.wiki.es.service;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by wiki on 2020/7/20 13:02
 */
@Component
public class EsTestService {

    @Autowired
    RestHighLevelClient restHighLevelClient;


    @Autowired
    UserESRepository userESRepository;

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;


    /**
     * 新增用户
     * @param user
     */

    public void  add(User user){
        userESRepository.save(user);
    };

    /**
     * 批量新增
     * @param list
     */
    public void add(List<User> list){
        userESRepository.saveAll(list);
    }

    public void getOne(Long id){

         userESRepository.findById(id);

    }

    public void getQuerySort() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.fuzzyQuery("1",1));
        searchSourceBuilder.sort("name", SortOrder.DESC);
        searchRequest.source(searchSourceBuilder);
        SearchResponse rs= restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = rs.getHits().getHits();
    }
}
