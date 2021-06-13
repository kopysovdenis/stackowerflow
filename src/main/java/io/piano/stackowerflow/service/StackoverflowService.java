package io.piano.stackowerflow.service;

import io.piano.stackowerflow.model.api.response.ItemResponse;

import java.util.Optional;

/**
 * @author KopysovDA
 * <p>Сервис для обработки поисковых запросов</p>
 * <p>Service for processing search queries </p>
 */
public interface StackoverflowService {
    Optional<ItemResponse> searchQuery(String query);
}
