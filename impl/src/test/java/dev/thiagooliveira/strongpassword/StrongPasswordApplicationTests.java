package dev.thiagooliveira.strongpassword;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StrongPasswordApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenValidPassword_thenReturns204() throws Exception {
        String validPassword = "vYQIY3O&p$yfI^r";
        Map<String, String> request = new HashMap<>();
        request.put("password", validPassword);

        mockMvc.perform(post("/validate-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(status().isNoContent());
    }

    @Test
    public void whenInvalidPassword_thenReturns400() throws Exception {
        String invalidPassword = "weakpass";
        Map<String, String> request = new HashMap<>();
        request.put("password", invalidPassword);

        mockMvc.perform(post("/validate-password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").isArray());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
