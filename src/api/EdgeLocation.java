package api;

public class EdgeLocation implements edge_location {

	private Node nodeSrc;//src
	private Node nodeDest;//dest
	private Edge edge;
	public EdgeLocation(Node n1, Node n2) {
		this.nodeSrc =n1;
		this.nodeDest =n1;
	}
	@Override
	public edge_data getEdge() {
		return nodeSrc.edgeCollection.get(nodeDest.getKey());
	}

	@Override
	public double getRatio() {
		// TODO Auto-generated method stub   //<--------------??????
		return 0;
	}

}
