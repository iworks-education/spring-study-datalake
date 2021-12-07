package br.com.iwe.springstudydatalake.web;

import br.com.iwe.springstudydatalake.resource.StudyResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCreateStudyRecordAndReturnCreated() throws Exception {

        final StudyResource study = new StudyResource.Builder().topic("SpringBoot")
                .tag("test")
                .url("https://spring.io")
                .dateTimeCreation(LocalDateTime.now())
                .build();

        mockMvc.perform(post("/study").contentType("application/json")
                        .content(objectMapper.writeValueAsString(study)))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetStudiesByTopic() throws Exception {

        final StudyResource studyResource = new StudyResource.Builder().topic("tdd")
                .tag("spring")
                .url("https://tdd.io")
                .dateTimeCreation(LocalDateTime.now())
                .build();

        mockMvc.perform(post("/study").contentType("application/json")
                        .content(objectMapper.writeValueAsString(studyResource)))
                .andExpect(status().isCreated());

        final MvcResult mvcResult = mockMvc.perform(get("/study/findByTopic")
                        .contentType("application/json")
                        .param("topic", "tdd"))
                .andExpect(status().isOk())
                .andReturn();

        final List<StudyResource> expectedResponseBody = Arrays.asList(studyResource);

        final String actualResponseBody = mvcResult.getResponse().getContentAsString();

        System.out.println(actualResponseBody);

        assertThat(actualResponseBody).isEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(expectedResponseBody));

    }
}
