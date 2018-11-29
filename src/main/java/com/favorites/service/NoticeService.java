package com.favorites.service;

import com.favorites.domain.view.CollectSummary;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoticeService {

    void saveNotice(String collectId, String type, Long userId, String operId);

    List<CollectSummary> getNoticeCollects(String type, Long userId, Pageable pageable);

}
