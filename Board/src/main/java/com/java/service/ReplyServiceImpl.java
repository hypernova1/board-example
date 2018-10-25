package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.domain.Criteria;
import com.java.domain.ReplyVO;
import com.java.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO dao;
	@Override
	public void addApply(ReplyVO vo) {
		dao.create(vo);
	}

	@Override
	public List<ReplyVO> listReply(Integer bno) {
		return dao.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) {
		dao.update(vo);
	}

	@Override
	public void deleteReply(Integer rno) {
		dao.delete(rno);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) {
		return dao.listPage(bno, cri);
	}

	@Override
	public int count(Integer bno) {
		return dao.count(bno);
	}

}
