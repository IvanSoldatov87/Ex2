package api;

import java.io.Serializable;
import java.util.HashMap;
/**
 * This calss represents the set of operations applicable on a
 * node (vertex) in a (directional) weighted graph.
 *
 */
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
	 * Returns the key (id) associated with this node.
	 * @return
	 */
	@Override
	public int getKey() {

		return this.key;
	}

	/** Returns the location of this node, if
	 * none return null.
	 *
	 * @return
	 */
	@Override
	public geo_location getLocation() {

		return this.geoLocation;
	}

	/** Allows changing this node's location.
	 * @param p - new new location  (position) of this node.
	 */
	@Override
	public void setLocation(geo_location p) {

		this.geoLocation = p;
	}

	/**
	 * Returns the weight associated with this node.
	 * @return
	 */
	@Override
	public double getWeight() {

		return this.nodeDataWeight;
	}

	/**
	 * Allows changing this node's weight.
	 * @param w - the new weight
	 */
	@Override
	public void setWeight(double w) {

		this.nodeDataWeight = w;
	}
	/**
	 * Returns the remark (meta data) associated with this node.
	 * @return
	 */
	@Override
	public String getInfo() {

		return this.nodeDataInfo;
	}
	/**
	 * Allows changing the remark (meta data) associated with this node.
	 * @param s
	 */
	@Override
	public void setInfo(String s) {

		this.nodeDataInfo = s;
	}
	/**
	 * Temporal data (aka color: e,g, white, gray, black)
	 * which can be used be algorithms
	 * @return
	 */
	@Override
	public int getTag() {

		return this.nodeDataTag;
	}
	/**
	 * Allows setting the "tag" value for temporal marking an node - common
	 * practice for marking by algorithms.
	 * @param t - the new value of the tag
	 */
	@Override
	public void setTag(int t) {

		this.nodeDataTag=t;
	}

}
