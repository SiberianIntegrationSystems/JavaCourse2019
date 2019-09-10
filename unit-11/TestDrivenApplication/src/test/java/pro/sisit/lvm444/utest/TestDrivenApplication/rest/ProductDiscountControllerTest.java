package pro.sisit.lvm444.utest.TestDrivenApplication.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pro.sisit.lvm444.utest.TestDrivenApplication.TestDrivenApplication;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.ProductDiscountServiceImpl;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDrivenApplication.class})
@WebAppConfiguration
public class ProductDiscountControllerTest {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Test
    public void getDiscount() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/discount/1?clientId=5")
                .accept(MediaType.ALL))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}