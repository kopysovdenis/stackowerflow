package io.piano.stackowerflow.feign;

import io.piano.stackowerflow.model.api.response.ItemResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author KopysovDA
 * <p>Интерфейс для взаимодействия с api stackoverflow (синхронные запросы)</p>
 * <p>Interface for interacting with the stackoverflow api (synchronous requests) </p>
 */
@FeignClient(name = "api/sync", url = "${base.api.url}", path = "${base.api.path}")
public interface ApiCallerFeignClientSync {

    /**
     * <p>Ищет на сайте любые вопросы, соответствующие заданным критериям.</p>
     * <p>Searches a site for any questions which fit the given criteria.</p>
     * <p>
     * Docs https://api.stackexchange.com/docs/search
     *
     * @param searchText поисковая строка/search text
     * @param order      порядок/order
     * @param site       сайт для поиска/search site
     * @param sort       порядок сортировки/sorting order
     * @return Упорядоченый список вопросов/An ordered list of questions
     */
    @GetMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ItemResponse> getData(@RequestParam("intitle") String searchText, @RequestParam("order") String order, @RequestParam("site") String site, @RequestParam("sort") String sort);
}
