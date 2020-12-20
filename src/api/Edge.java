package api;

import java.io.Serializable;
/**
 * This class represents the set of operations applicable on a
 * directional edge(src,dest) in a (directional) weighted graph.
 *
 */
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
	/**
	 * The id of the source node of this edge.
	 * @return
	 */
	@Override
	public int getSrc() {
		// TODO Auto-generated method stub
		return this.src;
	}
	/**
	 * The id of the destination node of this edge
	 * @return
	 */
	@Override
	public int getDest() {
		// TODO Auto-generated method stub
		return this.dest;
	}
	/**
	 * @return the weight of this edge (positive value).
	 */
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.edgeDataWeight;
	}
	/**
	 * Returns the remark (meta data) associated with this edge.
	 * @return
	 */
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.edgeDataInfo;
	}
	/**
	 * Allows changing the remark (meta data) associated with this edge.
	 * @param s
	 */
	@Override
	public void setInfo(String s) {
		this.edgeDataInfo=s;
		
	}
	/**
	 * Temporal data (aka color: e,g, white, gray, black)
	 * which can be used be algorithms
	 * @return
	 */
	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return this.edgeDataTag;
	}
	/**
	 * This method allows setting the "tag" value for temporal marking an edge - common
	 * practice for marking by algorithms.
	 * @param t - the new value of the tag
	 */
	@Override
	public void setTag(int t) {
		this.edgeDataTag=t;
		
	}

}
