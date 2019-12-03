package org.kjs.service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import org.kjs.domain.AuthVO;
import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.mapper.AuthMapper;
import org.kjs.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_= {@Autowired})
	MemberMapper mapper;
	@Setter(onMethod_= {@Autowired})
	AuthMapper authMapper;
	
	public String generateToken() {
	    SecureRandom random = new SecureRandom();
	    byte bytes[] = new byte[40];
	    random.nextBytes(bytes);
	    Encoder encoder = Base64.getUrlEncoder().withoutPadding();
	    String token = encoder.encodeToString(bytes);
	    return token;
	}
	
	@Override
	@Transactional
	public int join(MemberVO vo) {
		// TODO Auto-generated method stub
		vo.setToken(generateToken());
		mapper.insert(vo);
		authMapper.insert(new AuthVO(vo.getMemberId(),"ROLE_USER"));
		return 1;
	}

	@Override
	public int modify(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public MemberVO login(String email) {
		// TODO Auto-generated method stub
		return mapper.get(email);
	}

	@Override
	public Integer getIdByEmail(String email) {
		// TODO Auto-generated method stub
		return mapper.getIdByEmail(email);
	}

	@Override
	public int leave(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.delete(vo);
	}

	@Override
	public List<MemberVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPage(cri);
	}


	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

}
