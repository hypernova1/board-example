package com.java.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.domain.MemberVO;
import com.java.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class MemberDAOTest {

	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testTime() {
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testInsertMember() {
		MemberVO vo = new MemberVO();
		vo.setUserid("dd");
		vo.setPw("1111");
		vo.setName("ddd");
		vo.setEmail("dddd");
		dao.insertMember(vo);
	}
	
	@Test
	public void testReadMember() throws Exception {
		dao.readMember("1");
	}
}
