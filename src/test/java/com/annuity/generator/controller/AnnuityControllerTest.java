package com.annuity.generator.controller;

import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.annuity.generator.dto.AnnuityPlan;
import com.annuity.generator.dto.LoanDetails;
import com.annuity.generator.service.AnnuityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
public class AnnuityControllerTest {
	@InjectMocks
	private AnnuityController annuityController;
	@Mock
	AnnuityService annuityService;
	private MockMvc mockMvc;
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void init() {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(annuityController).build();

	}

	@Test
	public void generateAnnuityPlanControllerTest() throws Exception {
		LoanDetails loanDetailsReq = new LoanDetails();
		loanDetailsReq = createLoanDetails();
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(loanDetailsReq);

		List<AnnuityPlan> response = new ArrayList<AnnuityPlan>();
		response.add(new AnnuityPlan());

		doReturn(response).when(annuityService).getAnnuityPlan(anyObject());

		mockMvc.perform(post("/generate-plan").contentType(APPLICATION_JSON_UTF8).content(requestJson)).andDo(print())
				.andExpect(status().isOk()).andReturn();
	}

	public LoanDetails createLoanDetails() {
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setDuration(24);
		loanDetails.setStartDate(new Date());
		loanDetails.setNominalRate(5f);
		loanDetails.setLoanAmount(5000d);
		return loanDetails;
	}
}
