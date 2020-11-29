package api;

public class EdgeLocation implements edge_location {

	private NodeData nodeDataSrc;//src
	private NodeData nodeDataDest;//dest
	private EdgeData edgeData;
	public EdgeLocation(NodeData n1,NodeData n2) {
		this.nodeDataSrc=n1;
		this.nodeDataDest=n1;
	}
	@Override
	public edge_data getEdge() {
		return nodeDataSrc.edgeCollection.get(nodeDataDest.getKey());
	}

	@Override
	public double getRatio() {
		// TODO Auto-generated method stub   //<--------------??????
		return 0;
	}

}
