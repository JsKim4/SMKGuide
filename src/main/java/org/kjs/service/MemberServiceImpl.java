package org.kjs.service;

import java.util.List;

import org.kjs.domain.Criteria;
import org.kjs.domain.MemberVO;
import org.kjs.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_= {@Autowired})
	MemberMapper mapper;
	
	@Override
	public int join(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.insert(vo);
	}

	@Override
	public int modify(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.get(vo);
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
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public List<MemberVO> getListWithPage(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

}
