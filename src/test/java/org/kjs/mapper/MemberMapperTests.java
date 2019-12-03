package org.kjs.mapper;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private MobileMapper mmapper;
	
	@Test
	public void testGetByToken() {
		log.info(mmapper.getMemberByToken("0�6L�+�&��?������L��Ah)98�Ϩ)�"));
	}
	
	
	@Test
	public void testGetIdByEmail() {
		log.info(mapper.getIdByEmail("email"));
	}
	public String generateToken() {
	    SecureRandom random = new SecureRandom();
	    byte bytes[] = new byte[40];
	    random.nextBytes(bytes);
	    Encoder encoder = Base64.getUrlEncoder().withoutPadding();
	    String token = encoder.encodeToString(bytes);
	    return token;
	}
	@Test
	public void testUpdateToken() {
		MemberVO vo = new MemberVO();
		vo.setToken(generateToken());
		log.info(vo.getToken());
		vo.setMemberId(65l);
		mapper.updateToken(vo);
		
		
	}
	
	
	@Test
	public void testInsert() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest@test");
		vo.setPassword("1234");
		vo.setMemberName("insertName");
		vo.setAddress("address");
		vo.setTelephone("010-000-0000");
		mapper.insert(vo);
	}

	@Test
	public void testGet() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest@test");
		vo.setPassword("1234");
		log.info(vo);
	}

	@Test
	public void update() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest@test");
		vo.setPassword("1234");
		vo.setConfirmPassword("0000");
		vo.setMemberName("updateTest");
		mapper.update(vo);
	}

	@Test
	public void testDelete() {
		MemberVO vo = new MemberVO();
		vo.setEmail("insertTest@test");
		vo.setPassword("1234");
		mapper.delete(vo);
	}

	@Test
	public void testGetList() {
		mapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetListWithPage() {
		Criteria cri = new Criteria(2,10);
		cri.setStartIndex();
		mapper.getListWithPage(cri).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetTotalCount() {
		Criteria cri = new Criteria(1,10);
		cri.setStartIndex();
		log.info(mapper.getTotalCount(cri));
	}
}
