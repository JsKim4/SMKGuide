package org.kjs.mapper;

import java.util.List;

import org.kjs.domain.BrandVO;
import org.kjs.domain.Criteria;

public interface BrandMapper {
	public int insert(BrandVO vo);

	public void insertSelectKey(BrandVO vo);

	public int delete(Long brandId);

	public int update(BrandVO vo);

	public BrandVO get(Long brandId);

	public List<BrandVO> getList();

	public List<BrandVO> getListWithPage(Criteria cri);

	public int getTotalCount(Criteria cri);
}
