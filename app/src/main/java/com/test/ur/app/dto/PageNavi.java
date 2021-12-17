package com.test.ur.app.dto;

public class PageNavi {
	// ������ �׺���̼��� ���� ��ȣ
	int startPage;
	// ������ �׺���̼��� ����ȣ
	int endPage;
	// ���� ������ ����
	boolean prev;
	// ���� ������ ����
	boolean next;

	// ������ ����
	PagingDto paging;
	// �Խù��� �� �Ǽ�
	int total;
	
	int endPageNo;

	public PageNavi(PagingDto paging, int total) {
		this.paging = paging;
		this.total = total;
		
		endPageNo = (int) Math.ceil(total/10.0);
		// ������ �׺���̼��� �� ��ȣ
		endPage = (int) (Math.ceil(paging.getPageNo() / 10.0)) * 10;
		// ������ �׺���̼��� ���� ��ȣ
		startPage = endPage - 9;
		// ���� ������ ������ ��ȣ
		int realEndPage = (int) Math.ceil((total * 1.0) / paging.getAmount());

		// �׺���̼��� ������ ������ ��ȣ ���� ���� ������ ��ȣ�� Ŭ��� ������ ������ ��ȣ�� ����
		endPage = endPage > realEndPage ? realEndPage : endPage;

		prev = startPage > 1;

		// ���� ������ �������� ���� ������̼��� �� ������ ��ȣ ���� ũ��
		next = realEndPage > endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public PagingDto getPaging() {
		return paging;
	}

	public void setPaging(PagingDto paging) {
		this.paging = paging;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}
	
}
