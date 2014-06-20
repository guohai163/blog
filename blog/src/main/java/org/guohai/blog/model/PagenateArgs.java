package org.guohai.blog.model;

public class PagenateArgs {

	private int pageIndex;
	private int pageSize;
	private int pageStart;
	
	public PagenateArgs(){}
	
	public PagenateArgs(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        pageStart = pageIndex * pageSize;
    }
	
	public int getPageIndex() {
        return pageIndex;
    }

    public int getPageStart() {
        return pageStart;
    }

    public int getPageSize() {
        return pageSize;
    }
}
