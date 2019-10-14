package org.kjs.service;

import java.util.List;

import org.kjs.domain.CommentVO;
import org.kjs.domain.Criteria;
import org.kjs.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;


@Service
public class CommentServiceImpl implements CommentService {

	@Setter(onMethod_=@Autowired)
	CommentMapper mapper;
	
	@Override
	public int register(CommentVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertSelectKey(vo);
	}

	@Override
	public boolean modify(CommentVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long commentId) {
		// TODO Auto-generated method stub
		return mapper.delete(commentId) == 1 ? true : false;
	}

	@Override
	public CommentVO get(Long commentId) {
		// TODO Auto-generated method stub
		return mapper.get(commentId);
	}

	@Override
	public List<CommentVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

}
