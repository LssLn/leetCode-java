package classes;

public class RectangleSum {
	private Integer[] rows;
	private Integer[] columns;
	private Integer sum;
	
	public RectangleSum(Integer[] rows, Integer[] columns, Integer sum) {
		this.rows = rows;
		this.columns = columns;
		this.sum = sum;
	}

	public Integer[] getRows() {
		return rows;
	}

	public void setRows(Integer[] rows) {
		this.rows = rows;
	}

	public Integer[] getColumns() {
		return columns;
	}

	public void setColumns(Integer[] columns) {
		this.columns = columns;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
	
}
