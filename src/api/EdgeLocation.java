package api;
/**
 * This class represents a position on the graph (a relative position
 * on an edge - between two consecutive nodes).
 */
public class EdgeLocation implements edge_location {

	private Node nodeSrc;//src
	private Node nodeDest;//dest
	private Edge edge;
	public EdgeLocation(Node n1, Node n2) {
		this.nodeSrc =n1;
		this.nodeDest =n1;
	}
	/**
	 * Returns the edge on which the location is.
	 * @return
	 */
	@Override
	public edge_data getEdge() {
		return nodeSrc.edgeCollection.get(nodeDest.getKey());
	}
	/**
	 * Returns the relative ration [0,1] of the location between src and dest.
	 * @return
	 */
	@Override
	public double getRatio() {
		// TODO Auto-generated method stub   //<--------------??????
		return 0;
	}

}
