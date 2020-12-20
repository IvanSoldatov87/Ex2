package gameClient;
import Server.Game_Server_Ex2;
import api.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;
import java.util.stream.IntStream;

public class Ex2 implements Runnable {
	private static MyFrame _win;
	private static final LogInFrame lf = new LogInFrame();
	private static int id;
	private static int lvl;
	private static Arena _ar;
	private directed_weighted_graph gg;
	private static ArrayList<Integer> agentActyvity = new ArrayList<>();
	private static HashMap<String, Double> marshrut = new HashMap<>();

	public static void main(String[] a) {
		if (a.length > 0) {
			try {
				id = Integer.parseInt(a[0]);
				lvl = Integer.parseInt(a[1]);
			} catch (NumberFormatException e) {
				System.exit(0);
			}
			} else {
				lvl=-1;
				id=-1;
				lf.setSize(500,150);
				lf.setVisible(true);
				while (lf.isVisible()){
					lvl = lf.getLvl();
					id=lf.getId();
					System.out.print("");
				}
		}
		Thread client = new Thread(new Ex2());
		client.start();
	}

	@Override
	public void run() {
		game_service game = Game_Server_Ex2.getServer(lvl); // you have [0,23] games
		String graphString = game.getGraph();
		gg = loadGraph(graphString);
		init(game);
		game.startGame();
		_win.setTitle("Ex2:"+lvl);
		while(game.isRunning()) {
			moveAgents(game, gg);
			try {

				_win.repaint();
				Thread.sleep(90);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		String res = game.toString();
		System.out.println(res);
		System.exit(0);
	}

	public static directed_weighted_graph loadGraph(String s) {
		directed_weighted_graph g = new DWGraph_DS();
		try {
			JSONObject graph = new JSONObject(s);
			JSONArray edges=graph.getJSONArray("Edges");
			JSONArray nodes=graph.getJSONArray("Nodes");
			for (int i = 0; i < nodes.length() ; i++) {
				JSONObject n= nodes.getJSONObject(i);
				int key= n.getInt("id");
				node_data newNode= new Node(key);
				String[] arr= (n.getString("pos")).split(",");
				geo_location newGeoLocation= new GeoLocation(Double.parseDouble(arr[0]),Double.parseDouble(arr[1]),Double.parseDouble(arr[2]));
				newNode.setLocation(newGeoLocation);
				g.addNode(newNode);
			}
			for (int i = 0; i <edges.length(); i++) {
				JSONObject edg= edges.getJSONObject(i);
				g.connect(edg.getInt("src"),edg.getInt("dest"),edg.getDouble("w"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return g;
	}
	private static void moveAgents(game_service game, directed_weighted_graph gg) {

		String agentStatus = game.move();
		List<CL_Agent> agentColl = Arena.getAgents(agentStatus, gg);
		_ar.setAgents(agentColl);
		String pArr = game.getPokemons();
		_ar.setPokemons(Arena.json2Pokemons(pArr));
		for (int i = 0; i < _ar.getAgents().size(); i++) {
			CL_Agent ag = _ar.getAgents().get(i);
			if (ag.getNextNode() == -1) {
				agentActyvity.set(ag.getID(), -1);
				List<node_data> l = nextNode(gg, ag.getSrcNode(), ag);
				for (node_data temp : l) {
					game.chooseNextEdge(ag.getID(), temp.getKey());
				}
			}
		}
	}
private static List<node_data> nextNode(directed_weighted_graph g, int src,CL_Agent ag) {

		dw_graph_algorithms agg = new DWGraph_Algo();
		agg.init(g);

		double minDistance = Double.MAX_VALUE;
		int newDest = 0;
		int location;
		int index = 0;
		for (int i = 0; i < _ar.getPokemons().size(); i++) {
			Arena.updateEdge(_ar.getPokemons().get(i), g);
			location = _ar.getPokemons().get(i).get_edge().getSrc();

				String s = src + "," + location;
				double tempDistance;
				if (!(marshrut.containsKey(s))) {
					tempDistance = agg.shortestPathDist(src, location);
					marshrut.put(s, tempDistance);
				} else
					tempDistance = marshrut.get(s);
				if (tempDistance < minDistance) {
					minDistance = tempDistance;
					index = i;
					newDest = location;
				}
			}

		List<node_data> path = agg.shortestPath(src, newDest);
		int pDest = _ar.getPokemons().get(index).get_edge().getDest();
		agentActyvity.set(ag.getID(), newDest);
		path.add(g.getNode(pDest));
		return path;
	}
	private void init(game_service game) {
		String fs = game.getPokemons();
		directed_weighted_graph gg = this.gg;
		_ar = new Arena();
		_ar.setGraph(gg);
		_ar.setPokemons(Arena.json2Pokemons(fs));
		_win = new MyFrame("test Ex2");
		_win.setSize(1000, 700);
		_win.update(_ar);
		_win.show();
		String info = game.toString();
		JSONObject line;
		try {
			line = new JSONObject(info);
			JSONObject gameData = line.getJSONObject("GameServer");
			int rs = gameData.getInt("agents");
			//System.out.println(info + "\n");
			ArrayList<CL_Pokemon> pokColl = Arena.json2Pokemons(game.getPokemons());
			for (CL_Pokemon cl_pokemon : pokColl) {
				Arena.updateEdge(cl_pokemon, gg);
			}
			int n = pokColl.size();
			IntStream.range(0, n - 1).flatMap(i -> IntStream.range(0, n - i - 1)).filter(j -> pokColl.get(j).getValue() < pokColl.get(j + 1).getValue()).forEach(j -> {
				CL_Pokemon temp = pokColl.get(j);
				pokColl.set(j, pokColl.get(j + 1));
				pokColl.set(j + 1, temp);
			});
			for (int i = 0; i < rs; i++) {
				CL_Pokemon c = pokColl.get(i);
				int nn = c.get_edge().getSrc();
				game.addAgent(nn);
				agentActyvity.add(-1);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
