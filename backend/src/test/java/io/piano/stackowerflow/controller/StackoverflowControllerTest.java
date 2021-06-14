package io.piano.stackowerflow.controller;

import io.piano.stackowerflow.feign.ApiCallerFeignClientSync;
import io.piano.stackowerflow.model.api.response.Item;
import io.piano.stackowerflow.model.api.response.ItemResponse;
import io.piano.stackowerflow.service.StackoverflowService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Optional.of;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StackoverflowController.class)
@DisplayName("Testing a controller to work with the Stackoverflow API via REST")
class StackoverflowControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiCallerFeignClientSync apiCallerFeignClientSync;

    @MockBean
    private StackoverflowService stackoverflowService;

    @BeforeEach
    void setUp() {
        Item item = Item.builder()
                .build();

        ItemResponse itemResponse = ItemResponse.builder()
                .items(List.of(item))
                .hasMore(false)
                .quotaMax(1)
                .quotaRemaining(1)
                .build();

        when(apiCallerFeignClientSync.getData(anyString(), anyInt(), anyInt(), anyString(), anyString(), anyString())).thenReturn(ResponseEntity.ok(itemResponse));
        when(stackoverflowService.searchQuery(anyString(), anyInt(), anyInt(), anyString(), anyString(), anyString())).thenReturn(of(itemResponse));
    }

    @Test
    @DisplayName("Test for getting data from api")
    void getSearch() throws Exception {
        mockMvc.perform(get("/api/search")
                .param("intitle", "java%20s")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("quota_max", is(1)))
                .andDo(print())
                .andReturn();
    }
}
