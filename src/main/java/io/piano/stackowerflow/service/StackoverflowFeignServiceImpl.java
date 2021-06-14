package io.piano.stackowerflow.service;

import io.piano.stackowerflow.feign.ApiCallerFeignClientSync;
import io.piano.stackowerflow.model.api.response.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Optional.of;

/**
 * @author KopysovDA
 * <p>Сервис для обработки поисковых запросов</p>
 * <p> Service for processing search queries </p>
 */
@Service
@RequiredArgsConstructor
public class StackoverflowFeignServiceImpl implements StackoverflowService {

    private final ApiCallerFeignClientSync apiCallerFeignClientSync;

    @Override
    public Optional<ItemResponse> searchQuery(String searchText, Integer page, Integer pagesize, String order, String sort, String site) {
        ResponseEntity<ItemResponse> response = apiCallerFeignClientSync.getData(searchText, page, pagesize, order, sort, site);
        return of(response)
                .filter(isOk())
                .map(HttpEntity::getBody);
    }

    /**
     * <p>Проверяет код ответа на соответствие коду 200<p>
     * <p>Checks the response code against code 200<p>
     */
    private Predicate<ResponseEntity<ItemResponse>> isOk() {
        return r -> r.getStatusCode() == HttpStatus.OK;
    }
}
