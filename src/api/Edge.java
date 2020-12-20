package api;

import java.io.Serializable;

public class Edge implements edge_data,Serializable{

	private int src;
	private int dest;
	private double edgeDataWeight;
	private String edgeDataInfo;
	private int edgeDataTag;
	
	public Edge(double w) {
		this.edgeDataWeight=w;
	}
	public Edge(int src, int dest, double w) {
		this.edgeDataWeight=w;
		this.dest=dest;
		this.src=src;
	}


	public void setWeight(double w) {

		this.edgeDataWeight = w;
	}
	
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
