package util;

public class Pagination {
	private int totalRecords;
	private int rowPerPage;
	private int totalPage;
	private int currentPage;
	private int startRow;
	
	public Pagination(){
		totalRecords=0;
		rowPerPage=10;
		totalPage=1;
		currentPage=1;
		startRow=1;
	}
	
	public int getFirstPageNo(){
		return 1;
	}
	
	public int getLastPageNo(){
		return totalPage;
	}
	
	public int getPreviousPageNo(){
		if(currentPage<=1){
			return 1;
		}
		return currentPage-1;
	}
	
	public int getNextPageNo(){
		if(currentPage>=totalPage){
			return currentPage;
		}
		return currentPage+1;
	}
	
	
	public boolean isFirstPage(){
		return currentPage==1;
	}
	
	public boolean isLastPage(){
		return currentPage==totalPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		if(totalRecords==0){
			return ;
		}
		this.totalRecords=totalRecords;
		totalPage=(totalRecords+rowPerPage-1)/rowPerPage;
		if(currentPage<1){
			currentPage=1;
		}
		else if(currentPage>totalPage){
			currentPage=totalPage;
		}
		startRow=(currentPage-1)*rowPerPage+1;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	@Override
	public String toString() {
		return "Pagination [totalRecords=" + totalRecords + ", rowPerPage=" + rowPerPage + ", totalPage=" + totalPage
				+ ", currentPage=" + currentPage + ", startRow=" + startRow + "]";
	}
	
	
}
