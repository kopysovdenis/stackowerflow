package io.piano.stackowerflow.service;

import io.piano.stackowerflow.feign.ApiCallerFeignClientSync;
import io.piano.stackowerflow.model.api.response.Item;
import io.piano.stackowerflow.model.api.response.ItemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("Testing a service to work with the Stackoverflow API via REST")
class StackoverflowFeignServiceImplTest {

    private StackoverflowFeignServiceImpl stackoverflowFeignService;
    private ApiCallerFeignClientSync apiCallerFeignClientSync;

    @BeforeEach
    void setUp() {
        apiCallerFeignClientSync = mock(ApiCallerFeignClientSync.class);
        stackoverflowFeignService = new StackoverflowFeignServiceImpl(apiCallerFeignClientSync);
    }

    @Test
    @DisplayName("Retrieving a list of responses")
    void searchQuery() {
        Item item = Item.builder()
                .build();

        ItemResponse itemResponse = ItemResponse.builder()
                .items(List.of(item))
                .hasMore(false)
                .quotaMax(1)
                .build();

        when(apiCallerFeignClientSync.getData(anyString(), anyString(), anyString(), anyString())).thenReturn(ResponseEntity.ok(itemResponse));
        Optional<ItemResponse> result = stackoverflowFeignService.searchQuery("java");
        assertTrue(result.isPresent());
        verify(apiCallerFeignClientSync).getData(anyString(), anyString(), anyString(), anyString());
    }
}
