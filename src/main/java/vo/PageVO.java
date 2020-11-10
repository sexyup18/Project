package vo;

import java.util.List;

public class PageVO {
	
	private List<QnaVO> qblist;
	private int sno;
	private int eno;
	private int totalCount; 
	private int viewPage;       // 출력되는 현재페이지
	private int listPage = 20;  // 페이지당 보여줄 레코드갯수
	private int listPageNo = 5; // 페이지당 출력되는 Page갯수
	
	
	public List<QnaVO> getQblist() {
		return qblist;
	}
	public void setQblist(List<QnaVO> qblist) {
		this.qblist = qblist;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getViewPage() {
		return viewPage;
	}
	public void setViewPage(int viewPage) {
		this.viewPage = viewPage;
	}
	public int getListPage() {
		return listPage;
	}
	public void setListPage(int listPage) {
		this.listPage = listPage;
	}
	public int getListPageNo() {
		return listPageNo;
	}
	public void setListPageNo(int listPageNo) {
		this.listPageNo = listPageNo;
	}
	
	@Override
	public String toString() {
		return "PageVO [qblist=" + qblist + ", sno=" + sno + ", eno=" + eno + ", totalCount=" + totalCount
				+ ", viewPage=" + viewPage + ", listPage=" + listPage + ", listPageNo=" + listPageNo + "]";
	}
}
