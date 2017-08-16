package com.mycompany.bynder.service.bynder;

import com.mycompany.bynder.domain.BinderMedia;

import java.util.List;

public interface BynderMediaService {

    List<BinderMedia> synchronousQuery() throws IllegalAccessException;

}
