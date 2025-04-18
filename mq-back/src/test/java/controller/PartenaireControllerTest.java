package controller;


import org.bank.MqApplication;
import org.bank.entity.Partenaire;
import org.bank.repository.PartenaireRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = MqApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PartenaireControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PartenaireRepository partenaireRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        partenaireRepository.deleteAll();
    }

    @Test
    void shouldAddAndReturnPartenaire() throws Exception {
        Partenaire partenaire = new Partenaire();
        partenaire.setAlias("ALIAS");
        partenaire.setType("TYPE");
        partenaire.setDirection(Partenaire.Direction.INBOUND);
        partenaire.setApplication("APP1");
        partenaire.setProcessedFlowType(Partenaire.ProcessedFlowType.MESSAGE);
        partenaire.setDescription("Test partenaire");

        mockMvc.perform(post("/api/partenaires")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(partenaire)))
                .andExpect(jsonPath("$.alias").value("ALIAS"));
    }

    @Test
    void shouldListPartenaires() throws Exception {
        Partenaire partenaire = new Partenaire();
        partenaire.setAlias("ALIAS");
        partenaire.setType("TYPE");
        partenaire.setDirection(Partenaire.Direction.INBOUND);
        partenaire.setApplication("APP");
        partenaire.setProcessedFlowType(Partenaire.ProcessedFlowType.MESSAGE);
        partenaire.setDescription("List test");

        partenaireRepository.save(partenaire);

        mockMvc.perform(get("/api/partenaires"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].type", is("TYPE")));
    }
}

