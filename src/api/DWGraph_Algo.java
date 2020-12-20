package api;

import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.*;


public class DWGraph_Algo implements dw_graph_algorithms {

    private directed_weighted_graph graph = new DWGraph_DS();

    node_data tempNode=new Node();
    int maxInt=Integer.MAX_VALUE;
    Stack<Node> stack=new Stack<>();

    @Override
    public void init(directed_weighted_graph g) {

        this.graph = g;
    }

    @Override
    public directed_weighted_graph getGraph() {
        return this.graph;
    }

    @Override
    public directed_weighted_graph copy() {
    	directed_weighted_graph newG = new DWGraph_DS();
        for (node_data node : graph.getV()){
            node_data newNode = new Node(node.getKey());
            newNode.setInfo(node.getInfo());
            newNode.setLocation(node.getLocation());
            newNode.setTag(node.getTag());
            newNode.setWeight(node.getWeight());
            newG.addNode(newNode);
        }
        for (node_data node : graph.getV()){
            for (edge_data edge : graph.getE(node.getKey())){
                newG.connect( node.getKey(), edge.getDest(), edge.getWeight());
            }
        }
        return newG;
    }
    @Override
    public boolean isConnected() {

    	if(graph.getV().size()<2)return true;
        for (node_data nd : graph.getV()) {// fill zero in nodes  restart nodes
            nd.setInfo("");
            nd.setTag(0);
        }
    	Iterator<node_data> itt= graph.getV().iterator();
		dfs(itt.next());
		if(tempNode!=null) {
            for (node_data nd : graph.getV()) {// fill zero in nodes  restart nodes
                nd.setInfo("");
            }
			dfs(tempNode);
		}
        for (api.node_data node_data : graph.getV()) {
            if (node_data.getTag() < 2) return false;
        }
        return true;   
    }

    //need to check for connected graph and unconnected graph <-----------------------------------------------
    public void dfs(node_data node )
    {
        Queue<node_data> queue =new LinkedList<>();
        node_data nodeData;
        queue.add(node);
        while (!queue.isEmpty())
        {
        	nodeData = queue.remove();
        	nodeData.setInfo("V");
        	nodeData.setTag(nodeData.getTag()+1);
        	if(!(graph.getE(nodeData.getKey()).isEmpty())) {
                for (api.edge_data edge_data : graph.getE(nodeData.getKey())) {
                    Edge tempeEdge = (Edge) edge_data;
                    if (!graph.getNode(tempeEdge.getDest()).getInfo().equals("V")) {
                        queue.add(graph.getNode(tempeEdge.getDest()));
                    }
                }
            }
        	tempNode=nodeData;
        }
        
    }
	
    
    //need to check for running time <---------------------------------------------------??
    @Override
    public double shortestPathDist(int src, int dest) {
    	if(graph.getV().size()<2)return 0;
        for (node_data nd : graph.getV()) {// fill zero in nodes  restart nodes
            nd.setInfo("");
        }

        return dfs2(graph.getNode(src),graph.getNode(dest));
    }
    public int  dfs2(node_data node,node_data node2 )
    {
        Queue<node_data> queue =new LinkedList<>();
    	String visit="V";
        for(node_data i :this.graph.getV()){
            i.setTag(maxInt);
        }
        node_data nodeData;
        node.setTag(0);
        queue.add(node);
        while (!queue.isEmpty())
        {
        	nodeData = queue.remove();
        	nodeData.setInfo(visit);
        	stack.push((Node) nodeData);
        	if(nodeData.getKey()==node2.getKey()) return node2.getTag();
        	if(!graph.getE(nodeData.getKey()).isEmpty()) {
                for (api.edge_data edge_data : graph.getE(nodeData.getKey())) {
                    Edge tampEdge = (Edge) edge_data;
                    if (graph.getNode(tampEdge.getDest()).getInfo().equals("")) {
                        queue.add(graph.getNode(tampEdge.getDest()));
                        if (graph.getNode(tampEdge.getDest()).getTag() > graph.getEdge(nodeData.getKey(), graph.getNode(tampEdge.getDest()).getKey()).getWeight() + nodeData.getTag()) {
                            graph.getNode(tampEdge.getDest()).setTag((int) graph.getEdge(nodeData.getKey(), graph.getNode(tampEdge.getDest()).getKey()).getWeight() + nodeData.getTag());
                        }
                    }
                    if (graph.getNode(tampEdge.getDest()).getTag() > graph.getEdge(nodeData.getKey(), graph.getNode(tampEdge.getDest()).getKey()).getWeight() + nodeData.getTag()) {
                        graph.getNode(tampEdge.getDest()).setTag((int) graph.getEdge(nodeData.getKey(), graph.getNode(tampEdge.getDest()).getKey()).getWeight() + nodeData.getTag());
                    }
                }
            }
        }
        if(node2.getTag()==maxInt){ stack.clear();return -1;}
        return node2.getTag();     
    }
    
   //src--> n1-->n2-->...dest 
    @Override
    public List<node_data> shortestPath(int src, int dest) {//<-not work for this class function//need to update for running function
    	if(graph.getV().size()<2)return null;
    	int shorInt=dfs2(graph.getNode(src),graph.getNode(dest));
    	 List<node_data> result = new ArrayList<>() ;
        if(shorInt==-1){stack.clear();return result;}
    	 result.add(graph.getNode(dest));
	    	Node stackNode1;
	    	Node stackNode2;
	    	stackNode1=stack.pop();
	    	while(!stack.isEmpty()) {
	    		stackNode2=stack.pop();
	    		if(graph.getEdge(stackNode2.getKey(), stackNode1.getKey())!=null && (stackNode1.getTag()-stackNode2.getTag())==graph.getEdge(stackNode2.getKey(), stackNode1.getKey()).getWeight()) {
	    			stackNode1=stackNode2;
	    			result.add(stackNode1);
	    		}
	    	}
	    	if(!stack.empty())
	    	stack.clear();
	    	Collections.reverse(result);
        return result;
    }

    
    
    @Override
    public boolean save(String file) {
        if ((graph.nodeSize() == 0) || (graph == null)) return false;
        JSONArray nodeData = new JSONArray();
        JSONArray edgeData = new JSONArray();
        Iterator<node_data> it = graph.getV().iterator();
        while (it.hasNext()) {
            node_data tempNode = it.next();
            JSONObject obj = new JSONObject();
            try {
                StringBuilder pos= new StringBuilder();
                pos.append(tempNode.getLocation().x());
                pos.append(",");
                pos.append(tempNode.getLocation().y());
                pos.append(",");
                pos.append(tempNode.getLocation().z());
                obj.put("pos",pos.toString());
                obj.put("id", tempNode.getKey());
                nodeData.put(obj);
                obj = new JSONObject();
                HashMap<Integer, edge_data> edgeCall = (HashMap<Integer, edge_data>) graph.getE(tempNode.getKey());
                for (Integer i : edgeCall.keySet()) {
                    obj.put("src", tempNode.getKey());
                    obj.put("w", edgeCall.get(i).getWeight());
                    obj.put("dest", (i));
                    edgeData.put(obj);
                    obj = new JSONObject();
                }

            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        JSONObject data = new JSONObject();
        try {
            data.put("Edges", edgeData);
            data.put("Nodes", nodeData);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;

        }
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data.toString());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;

        }
    }
    public boolean load(String file) {
        try {
            Gson gson = new Gson();
            JsonObject jsonOb = new JsonParser().parse(new FileReader(file)).getAsJsonObject();
            JsonArray nodesArray = jsonOb.getAsJsonArray("Nodes");
            directed_weighted_graph g = new DWGraph_DS();
            for (JsonElement node : nodesArray) {
                String[] nodePosition = ((JsonObject) node).get("pos").getAsString().split(",");
                geo_location location3d = new GeoLocation(Double.parseDouble(nodePosition[0]), Double.parseDouble(nodePosition[1]), Double.parseDouble(nodePosition[2]));
                Node nd=new Node(((JsonObject)node).get("id").getAsInt());
                nd.setLocation(location3d);
                g.addNode(nd);
            }

            JsonArray edgesArray = jsonOb.getAsJsonArray("Edges");
            for (JsonElement edge : edgesArray){
                JsonObject e = (JsonObject)edge;
                g.connect(e.get("src").getAsInt(),e.get("dest").getAsInt(),e.get("w").getAsDouble());
            }
            this.graph = g;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
