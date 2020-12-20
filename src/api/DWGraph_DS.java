package api;

import java.io.Serializable;
import java.util.*;

public class DWGraph_DS implements directed_weighted_graph,Serializable {
	//private int key;
	HashMap<Integer, Node> nodeCollection=new HashMap<>();
	public Collection<Edge> edgeColl =new LinkedList<>();
	
	private int edgeNum=0;
	private int modeCount=0;

	@Override
	public node_data getNode(int key) {

		return nodeCollection.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		if(getNode(src) != null && getNode(dest) != null){
			if(nodeCollection.get(src).edgeCollection.get(dest) != null){
				return nodeCollection.get(src).edgeCollection.get(dest);
			}
		}
		return null;
	}
	@Override
	public void addNode(node_data n) {
		nodeCollection.put(n.getKey(), (Node) n);
		modeCount++;
	}
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
	@Override
	public Collection<node_data> getV() {

		Collection<node_data> tempCollection = new ArrayList<>();
		tempCollection.addAll(nodeCollection.values());//casting
		return tempCollection;
	}
	@Override
	public Collection<edge_data> getE(int node_id) {
		Collection<edge_data> tempCollection = new ArrayList<>();
		tempCollection.addAll(nodeCollection.get(node_id).edgeCollection.values());
		return tempCollection;
	}
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
	@Override
	public int nodeSize() {
		return nodeCollection.size();
	}
	@Override
	public int edgeSize() {
		return edgeNum;
	}
	@Override
	public int getMC() {

		return modeCount;
	}

}
