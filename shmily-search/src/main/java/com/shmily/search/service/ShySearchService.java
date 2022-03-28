package com.shmily.search.service;

/**
 * @author WangXiang
 * @date 2022/3/27 21:15
 */
public interface ShySearchService
{
    /**
     * 内容全文搜索
     * @param keyword
     * @return
     */
    String contentSearch(String keyword);
}
