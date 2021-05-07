package de.swapab.csvupload.controller;

import java.io.File;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CsvUploadController.class)
class CsvUploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCsvUpload() throws Exception {
        String resourceName = "test.csv";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(resourceName)).getFile());

        MockMultipartFile mockCsvFile = new MockMultipartFile("file", "test.csv", "application/csv", file.toString().getBytes());
        RequestBuilder request = MockMvcRequestBuilders
                .multipart("/api/upload/csv")
                .file(mockCsvFile)
                .characterEncoding("UTF-8");
        mockMvc.perform(request).andExpect(status().isOk());
    }
}
