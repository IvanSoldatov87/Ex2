package api;

import java.io.Serializable;
import java.util.*;

public class DWGraph_DS implements directed_weighted_graph,Serializable {
	//private int key;
	HashMap<Integer, Node> nodeCollection=new HashMap<>();
	public Collection<Edge> edgeColl =new LinkedList<>();
	
	private int edgeNum=0;
	private int modeCount=0;
	/**
	 * returns the node_data by the node_id,
	 * @param key - the node_id
	 * @return the node_data by the node_id, null if none.
	 */
	@Override
	public node_data getNode(int key) {

		return nodeCollection.get(key);
	}
	/**
	 * returns the data of the edge (src,dest), null if none.
	 * Note: this method should run in O(1) time.
	 * @param src
	 * @param dest
	 * @return
	 */
	@Override
	public edge_data getEdge(int src, int dest) {
		if(getNode(src) != null && getNode(dest) != null){
			if(nodeCollection.get(src).edgeCollection.get(dest) != null){
				return nodeCollection.get(src).edgeCollection.get(dest);
			}
		}
		return null;
	}
	/**
	 * adds a new node to the graph with the given node_data.
	 * Note: this method should run in O(1) time.
	 * @param n
	 */
	@Override
	public void addNode(node_data n) {
		nodeCollection.put(n.getKey(), (Node) n);
		modeCount++;
	}
	/**
	 * Connects an edge with weight w between node src to node dest.
	 * * Note: this method should run in O(1) time.
	 * @param src - the source of the edge.
	 * @param dest - the destination of the edge.
	 * @param w - positive weight representing the cost (aka time, price, etc) between src-->dest.
	 */
	@Override
	public void connect(int src, int dest, double w) {
		if(getNode(src) != null && getNode(dest) != null){// if two nodes exist in this graph
			if(getEdge(src, dest) == null){// if edge not exist
				Edge edge=new Edge(src,dest,w);
				nodeCollection.get(src).edgeCollection.put(dest, edge);
				edgeColl.add(edge);
				edgeNum++;
				modeCount++;
			}
			else{
				// TODO: 05/12/2020 : check what about mode count.
				nodeCollection.get(src).edgeCollection.get(dest).setWeight(w);
				modeCount++;
			}
		}
	}
	/**
	 * This method returns a pointer (shallow copy) for the
	 * collection representing all the nodes in the graph.
	 * Note: this method should run in O(1) time.
	 * @return Collection<node_data>
	 */
	@Override
	public Collection<node_data> getV() {

		Collection<node_data> tempCollection = new ArrayList<>();
		tempCollection.addAll(nodeCollection.values());//casting
		return tempCollection;
	}
	/**
	 * This method returns a pointer (shallow copy) for the
	 * collection representing all the edges getting out of
	 * the given node (all the edges starting (source) at the given node).
	 * Note: this method should run in O(k) time, k being the collection size.
	 * @return Collection<edge_data>
	 */
	@Override
	public Collection<edge_data> getE(int node_id) {
		Collection<edge_data> tempCollection = new ArrayList<>();
		tempCollection.addAll(nodeCollection.get(node_id).edgeCollection.values());
		return tempCollection;
	}
	/**
	 * Deletes the node (with the given ID) from the graph -
	 * and removes all edges which starts or ends at this node.
	 * This method should run in O(k), V.degree=k, as all the edges should be removed.
	 * @return the data of the removed node (null if none).
	 * @param key
	 */
	@Override
	public node_data removeNode(int key) {  //<---------not O(1) tis method is  O(n)!!!
		if(nodeCollection.get(key)!=null) {
			Node tempNode=nodeCollection.get(key);
			edgeNum -= tempNode.edgeCollection.size();
			nodeCollection.remove(key);
			Iterator<Edge> edgeIt=edgeColl.iterator();
			Collection<edge_data> arr=new ArrayList<>();
			while (edgeIt.hasNext()){
				Edge edge = edgeIt.next();
				if(edge.getDest()==key || edge.getSrc()==key)arr.add(edge);
			}
			edgeColl.removeAll(arr);

			for(int i=0;i<=nodeCollection.size();i++) {
				if (nodeCollection.get(i) != null) {
					if (nodeCollection.get(i).edgeCollection.get(key) != null) {
						edgeNum--;
						Edge edge = nodeCollection.get(i).edgeCollection.get(key);
						nodeCollection.get(i).edgeCollection.remove(key);
					}
				}
			}
			modeCount++;
			return tempNode;
		}
		return null;
	}
	/**
	 * Deletes the edge from the graph,
	 * Note: this method should run in O(1) time.
	 * @param src
	 * @param dest
	 * @return the data of the removed edge (null if none).
	 */
	@Override
	public edge_data removeEdge(int src, int dest) {
		modeCount++;
		if(nodeCollection.get(src) != null && nodeCollection.get(src).edgeCollection.get(dest)!=null) {
			Edge tempEdge = nodeCollection.get(src).edgeCollection.get(dest);
			nodeCollection.get(src).edgeCollection.remove(dest);
			edgeNum--;
			edgeColl.remove(tempEdge);
			return tempEdge;
		}
		return null;
	}
	/** Returns the number of vertices (nodes) in the graph.
	 * Note: this method should run in O(1) time.
	 * @return
	 */
	@Override
	public int nodeSize() {
		return nodeCollection.size();
	}
	/**
	 * Returns the number of edges (assume directional graph).
	 * Note: this method should run in O(1) time.
	 * @return
	 */
	@Override
	public int edgeSize() {
		return edgeNum;
	}
	/**
	 * Returns the Mode Count - for testing changes in the graph.
	 * @return
	 */
	@Override
	public int getMC() {

		return modeCount;
	}

}
