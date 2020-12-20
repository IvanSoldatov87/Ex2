package api;

import java.io.Serializable;
import java.util.HashMap;

public class Node implements node_data,Serializable{

	private int key;
	private geo_location geoLocation=null;
	private double nodeDataWeight=0;
	private String nodeDataInfo="";
	private int nodeDataTag;
	HashMap<Integer, Edge> edgeCollection=new HashMap<>();

	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(int key) {
		this.key=key;
	}
	/**
	 *this method return the key variable.
	 */
	@Override
	public int getKey() {

		return this.key;
	}

	/**
	 * @return :return the geo location of this node (Three-dimensional coordinates)
	 */
	@Override
	public geo_location getLocation() {

		return this.geoLocation;
	}

	/**
	 * this method changing the node location.
	 *
	 * @param p - new new location  (position) of this node.
	 */
	@Override
	public void setLocation(geo_location p) {

		this.geoLocation = p;
	}

	/**
	 * @return:Weight  returns the whet of this node.
	 */
	@Override
	public double getWeight() {

		return this.nodeDataWeight;
	}

	/**
	 *
	 * @param w - the new weight
	 */
	@Override
	public void setWeight(double w) {

		this.nodeDataWeight = w;
	}

	@Override
	public String getInfo() {

		return this.nodeDataInfo;
	}
	@Override
	public void setInfo(String s) {

		this.nodeDataInfo = s;
	}

	@Override
	public int getTag() {

		return this.nodeDataTag;
	}

	@Override
	public void setTag(int t) {

		this.nodeDataTag=t;
	}

}
