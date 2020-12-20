package test;

import api.*;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {
    @Test
    void isConnected() {
        directed_weighted_graph g0 = new DWGraph_DS();
        for (int i = 0; i < 4; i++) {
            g0.addNode(new Node(i));
        }
        g0.connect(0, 1, 1);
        g0.connect(1, 2, 1);
        g0.connect(2, 3, 1);
        g0.connect(3, 0, 1);
        dw_graph_algorithms ag0 = new DWGraph_Algo();
        ag0.init(g0);
        assertTrue(ag0.isConnected());
        g0.removeNode(0);
        assertFalse(ag0.isConnected());
    }
    @Test
    void shortPathDest() {
        directed_weighted_graph g0 = new DWGraph_DS();
        for (int i = 0; i < 5; i++) {
            g0.addNode(new Node(i));
        }
        g0.connect(0, 1, 1);
        g0.connect(1, 3, 1);
        g0.connect(0, 2, 2);
        g0.connect(2, 1, 1);
        g0.connect(2, 4, 2);
        g0.connect(1, 4, 6);
        g0.connect(3, 4, 1);
        dw_graph_algorithms ag0 = new DWGraph_Algo();
        ag0.init(g0);
        assertEquals(3,ag0.shortestPathDist(0,4));
        g0.removeNode(1);
        assertEquals(-1,ag0.shortestPathDist(0,3));
    }
    @Test
    void shortPathList() {
        directed_weighted_graph g0 = new DWGraph_DS();
        for (int i = 0; i < 5; i++) {
            g0.addNode(new Node(i));
        }
        g0.connect(0, 1, 1);
        g0.connect(1, 3, 1);
        g0.connect(0, 2, 2);
        g0.connect(2, 1, 1);
        g0.connect(2, 4, 2);
        g0.connect(1, 4, 6);
        g0.connect(3, 4, 1);
        dw_graph_algorithms ag0 = new DWGraph_Algo();
        ag0.init(g0);
        int[] src=getKeys(ag0.shortestPath(0,4));
        for(int i=0;i<src.length;i++){
            System.out.print(src[i]+" ");
        }
        g0.removeNode(1);
        int[] src2=getKeys(ag0.shortestPath(0,4));
        if(src2.length>0){
        for(int i=0;i<src.length;i++){
            System.out.print(src2[i]+" ");
        }}
    }
    public int[] getKeys(List<node_data> n){
        int[] arr=new int[n.size()];
        Iterator<node_data> it =n.iterator();
        int i=0;
        while (it.hasNext()){
            arr[i]=it.next().getKey();
            i++;
        }
        return arr;
    }
}
