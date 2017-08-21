package com.fancy.lombokdemo;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fancy.lombokdemo.core.domain.UserDO;
import com.fancy.lombokdemo.core.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class LombokDemoApplicationTest {

	@Resource
	private UserService userService;
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	public void testServiceGet() {
		UserDO userDO = userService.get(1L);
		log.info("userDO:{}",userDO);
		Assert.assertEquals("userService.get有问题", "王磊", userDO.getName());
	}

	@Test
    public void testControllerGet() throws Exception {
		ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/get").param("id", "1").accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = resultActions.andReturn();
        String responseString  = mvcResult.getResponse().getContentAsString();
        log.info("responseString:{}",responseString);
        Assert.assertTrue("userController.get有问题", responseString.contains("王磊"));
    }
}
