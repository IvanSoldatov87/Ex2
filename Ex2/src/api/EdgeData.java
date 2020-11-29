package api;

public class EdgeData implements edge_data{

	private int src;
	private int dest;
	private double edgeDataWeight;
	private String edgeDataInfo;
	private int edgeDataTag;
	
	@Override
	public int getSrc() {
		// TODO Auto-generated method stub
		return this.src;
	}

	@Override
	public int getDest() {
		// TODO Auto-generated method stub
		return this.dest;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.edgeDataWeight;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.edgeDataInfo;
	}

	@Override
	public void setInfo(String s) {
		this.edgeDataInfo=s;
		
	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return this.edgeDataTag;
	}

	@Override
	public void setTag(int t) {
		this.edgeDataTag=t;
		
	}

}
