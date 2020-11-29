package api;

import java.util.HashMap;import javax.crypto.spec.IvParameterSpec;

public class NodeData implements node_data{
	private int key;
	private geo_location geoLocation=null;
	private double nodeDataWeight=0;
	private String nodeDataInfo="";
	private int nodeDataTag;
	HashMap<Integer, EdgeData> edgeCollection=new HashMap<Integer, EdgeData>();//tamplet
	
	
	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}
	@Override
	public geo_location getLocation() {
		// TODO Auto-generated method stub
		return this.geoLocation;
	}
	@Override
	public void setLocation(geo_location p) {
		this.geoLocation=p;
		
	}
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.nodeDataWeight;
	}
	@Override
	public void setWeight(double w) {
		this.nodeDataWeight=w;
		
	}
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.nodeDataInfo;
	}
	@Override
	public void setInfo(String s) {
		this.nodeDataInfo=s;
		
	}
	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return this.nodeDataTag;
	}
	@Override
	public void setTag(int t) {
		this.nodeDataTag=t;
		
	}
	

}
