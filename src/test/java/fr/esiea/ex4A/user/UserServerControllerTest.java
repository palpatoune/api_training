package fr.esiea.ex4A.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class UserServerControllerTest {
    private final MockMvc mockMvc;

    @MockBean
    private User user;

    UserServerControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void post_Api_Inscription_Test() throws Exception {
        User userTest = new User( "machin@truc.com",
                                 "machin",
                                "machin45",
                                "FR",
                                   "M",
                                "M");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

        String requestJson=ow.writeValueAsString(userTest );

        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/inscription").contentType(APPLICATION_JSON)
            .content(requestJson))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                        {
                            "userEmail": "machin@truc.com",
                            "userName": "machin",
                            "userTweeter": "machin45",
                            "userCountry": "FR",
                            "userSex": "M",
                            "userSexPref": "M"
                        }
                        """));
    }

    @Test
    void get_Matches_Test() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?name=Bob&country=FR"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(content().json("""
                        {
                            "userName": "Bob",
                            "userTweeter": "bobTweeter",
                            "userCountry": "Fr"
                        }
                        """));


    }
}


