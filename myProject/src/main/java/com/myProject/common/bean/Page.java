package com.myProject.common.bean;


import java.util.List;  
  
public class Page<T> {  
  
    public static final int DEFAULT_PAGE_SIZE = 10;  
  
    protected int pageNo = 1; // ��ǰҳ, Ĭ��Ϊ��1ҳ  
    protected int pageSize = DEFAULT_PAGE_SIZE; // ÿҳ��¼��  
    protected long totalRecord = -1; // �ܼ�¼��, Ĭ��Ϊ-1, ��ʾ��Ҫ��ѯ  
    protected int totalPage = -1; // ��ҳ��, Ĭ��Ϊ-1, ��ʾ��Ҫ����  
  
    protected List<T> results; // ��ǰҳ��¼List��ʽ  
      
   // public Map<String, Object> params = new HashMap<String, Object>();//����ҳ�洫�ݵĲ�ѯ���� 
    
    public T object;
  
   /* public Map<String, Object> getParams() {  
        return params;  
    }  
  
    public void setParams(Map<String, Object> params) {  
        this.params = params;  
    }  */
  
    public Page(){};
    
    
    public Page(String pageNo,String pageSize)
    {
    	if(pageNo != null && !"".equals(pageNo) && !"null".equals(pageNo))
    	{
    		this.pageNo = Integer.valueOf(pageNo);
    	}
    	if(pageSize != null && !"".equals(pageSize) && !"null".equals(pageSize))
    	{
    		this.pageSize = Integer.valueOf(pageSize);
    	}
    };
    
    
    
    
    public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}
    
    
    public int getPageNo() {  
        return pageNo;  
    }  

	public void setPageNo(int pageNo) {  
        this.pageNo = pageNo;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
        computeTotalPage();  
    }  
  
    public long getTotalRecord() {  
        return totalRecord;  
    }  
  
    public int getTotalPage() {  
        return totalPage;  
    }  
  
    public void setTotalRecord(long totalRecord) {  
        this.totalRecord = totalRecord;  
        computeTotalPage();  
    }  
  
    protected void computeTotalPage() {  
        if (getPageSize() > 0 && getTotalRecord() > -1) {  
            this.totalPage = (int) (getTotalRecord() % getPageSize() == 0 ? getTotalRecord() / getPageSize() : getTotalRecord() / getPageSize() + 1);  
        }  
    }  
  
    public List<T> getResults() {  
        return results;  
    }  
  
    public void setResults(List<T> results) {  
        this.results = results;  
    }  
  
    @Override  
    public String toString() {  
        StringBuilder builder = new StringBuilder().append("Page [pageNo=").append(pageNo).append(", pageSize=").append(pageSize)  
                .append(", totalRecord=").append(totalRecord < 0 ? "null" : totalRecord).append(", totalPage=")  
                .append(totalPage < 0 ? "null" : totalPage).append(", curPageObjects=").append(results == null ? "null" : results.size()).append("]");  
        return builder.toString();  
    }  
  
}  