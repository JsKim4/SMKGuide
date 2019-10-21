package org.kjs.service;

import java.util.List;

import org.kjs.domain.CommentVO;
import org.kjs.domain.Criteria;
import org.kjs.mapper.CommentMapper;
import org.kjs.mapper.TobaccoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;


@Service
public class CommentServiceImpl implements CommentService {

	@Setter(onMethod_=@Autowired)
	CommentMapper mapper;
	@Setter(onMethod_=@Autowired)
	TobaccoMapper tobaccoMapper;
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	@Transactional
	@Override
	public int register(CommentVO vo) {
		// TODO Auto-generated method stub
		tobaccoMapper.updateCommentCnt(vo.getTobacco().getTobaccoId(), 1);
		log.info(vo+"");
		return mapper.insertSelectKey(vo);
	}

	@Override
	public boolean modify(CommentVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo) == 1 ? true : false;
	}
	
	
	@Transactional
	@Override
	public boolean remove(Long commentId) {
		// TODO Auto-generated method stub
		CommentVO vo = mapper.get(commentId);
		log.info(vo+"");
		tobaccoMapper.updateCommentCnt(vo.getTobacco().getTobaccoId(), -1);
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
