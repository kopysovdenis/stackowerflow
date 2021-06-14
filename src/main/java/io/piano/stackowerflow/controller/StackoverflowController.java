package io.piano.stackowerflow.controller;


import io.piano.stackowerflow.model.api.response.ItemResponse;
import io.piano.stackowerflow.service.StackoverflowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class StackoverflowController {

    private final StackoverflowService stackoverflowService;

    /**
     * <p>GET root/search</p>
     * <p>Get search results</p>
     *
     * @param searchText поисковый запрос/request text
     * @return ResponseEntity<ItemResponse> a list of questions
     * desc&sort=activity&intitle=java&site=stackoverflow
     */
    @GetMapping(value = "/search")
    public ResponseEntity<ItemResponse> getSearch(@RequestParam("intitle") String searchText,
                                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                  @RequestParam(value = "pagesize", required = false, defaultValue = "30") Integer pagesize,
                                                  @RequestParam(value = "order", required = false, defaultValue = "desc") String order,
                                                  @RequestParam(value = "sort", required = false, defaultValue = "activity") String sort,
                                                  @RequestParam(value = "site", required = false, defaultValue = "stackoverflow") String site) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        return stackoverflowService.searchQuery(searchText, page, pagesize, order, sort, site)
                .map(p -> new ResponseEntity<>(p, headers, OK))
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }
}
