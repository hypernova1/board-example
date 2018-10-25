package com.java.domain;

import org.springframework.stereotype.Component;

@Component
public class Criteria {

	private int page;
	private int perPageNum;
	
	{
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return this.page;
	}
	
	public int getPageStart() {
		//시작 데이터 번호 = (페이지 번호 - 1) * 페이지 당 보여지는 개수
		return (this.page - 1) * perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
}
