package com.spring.cloud.prodoctserver.service;

import com.spring.cloud.prodoctapi.domain.Prodoct;

import java.util.List;

/**
 * @author AGbetrayal
 * @date 2019/6/21 22:33
 */
public interface IProdoctService {
    List<Prodoct> list();
}
