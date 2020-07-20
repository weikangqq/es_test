package com.gds.wiki.es.service;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Date;

/** 封装 es api 工具 具体面向对象 返回Entity
 * Created by wiki on 2020/7/20 15:00
 */
public class ESQueryUtils<T> {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    public SearchRequest searchRequest;





}
