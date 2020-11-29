package api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DWGraph_DS implements directed_weighted_graph {
	//private int key;
	HashMap<Integer, NodeData> nodeCollection=new HashMap<Integer, NodeData>();
	
	private int edgeNum=0;
	private int modeCount=0;
	@Override
	public node_data getNode(int key) {
		// TODO Auto-generated method stub
		return nodeCollection.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return nodeCollection.get(src).edgeCollection.get(dest);
	}

	@Override
	public void addNode(node_data n) {
		modeCount++;
		nodeCollection.put(n.getKey(), (NodeData) n);
		
	}

	@Override
	public void connect(int src, int dest, double w) {
		nodeCollection.get(src).edgeCollection.put(dest, new EdgeData(w));
		edgeNum++;
		modeCount++;
	}

	@Override
	public Collection<node_data> getV() {
		Collection<node_data> tempCollection=new ArrayList<node_data>();
		tempCollection.addAll(nodeCollection.values());//casting
		return tempCollection;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		Collection<edge_data> tempCollection=new ArrayList<edge_data>();
		tempCollection.addAll(nodeCollection.get(node_id).edgeCollection.values());
		return tempCollection;
	}

	@Override
	public node_data removeNode(int key) {
		if(nodeCollection.get(key)!=null) {
			modeCount++;
			NodeData tempNode=nodeCollection.get(key);
			edgeNum-=tempNode.edgeCollection.size();
			nodeCollection.remove(key);
			for(int i=0;i<nodeCollection.size();i++) {
				if(nodeCollection.get(i).edgeCollection.get(key)!=null) {
					edgeNum--;
					nodeCollection.get(i).edgeCollection.remove(key);
				}
			}
			return tempNode;
		}
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		modeCount++;
		if(nodeCollection.get(src)!=null && nodeCollection.get(src).edgeCollection.get(dest)!=null) {
			EdgeData tempEdge=nodeCollection.get(src).edgeCollection.get(dest);
			nodeCollection.get(src).edgeCollection.remove(dest);
			edgeNum--;
			return tempEdge;
		}
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return nodeCollection.size();
	}

	@Override
	public int edgeSize() {//problen in O(1)
		// TODO Auto-generated method stub
		return edgeNum;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return modeCount;
	}

}
