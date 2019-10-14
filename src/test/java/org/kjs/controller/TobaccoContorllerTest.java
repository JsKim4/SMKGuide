package org.kjs.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class TobaccoContorllerTest {
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx; // servlet-context를 이용하기 위한 변수

	private MockMvc mockMvc;// 가짜MVC *controller 시험용*

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/tobacco/list")
						.param("pageNum","1").param("amount", "10").
						param("type", "B").param("bId", "8"))
				.andReturn().getModelAndView().getModelMap());

	}

	@Test
	public void testRegist() throws Exception {
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/tobacco/register")
						.param("tobaccoName", "담배명")
						.param("tar", "2.0")
						.param("nicotine", "20.0")
						.param("price", "10000")
						.param("country.id","6")
						.param("company.id","1")
						.param("type.id", "1")
						.param("brand.id", "21"))
				.andReturn().getModelAndView().getViewName();
		log.info("info : "+resultPage);
	}

	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/tobacco/get")
				.param("tobaccoId", "15")).andReturn()
				.getModelAndView().getModelMap());
	}

	@Test
	public void modifyTest() throws Exception {
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/tobacco/modify")
						.param("tobaccoId", "15")
						.param("tobaccoName", "marlboro15")
						.param("tar", "2.0")
						.param("nicotine", "20.0")
						.param("country.id","6")
						.param("company.id","1")
						.param("type.id", "1")
						.param("brand.id", "21"))
				.andReturn().getModelAndView().getViewName();
		log.info("resultPage : " + resultPage);
	}

	@Test
	public void removeTest() throws Exception {
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/tobacco/remove")
						.param("tobaccoId", "17")).andReturn()
				.getModelAndView().getViewName();
		log.info(resultPage);
	}
}
