package ca.dss.csd.cct.project.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class AppDataControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void shouldReturnAppDataDisplayPage() throws Exception {
        this.mockMvc.perform(get("/data/getAll").param("pageNo","3").with(user("susan").password("test123").roles("ADMIN")))
                .andExpect(view().name("data/displayData"));
    }

    @Test
    public void shouldUpdateDataEntryAndRedirect() throws Exception {
        this.mockMvc.perform(get("/data/updateDataEntry")
                .with(user("susan").password("test123").roles("ADMIN"))
                .param("id", "1"))
                .andExpect(view().name("data/dataEntryForm"));
    }
}
