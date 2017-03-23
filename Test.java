import java.util.ArrayList;

public class Test{

	public static void main(String[] args){
		
		//Creates GNodes for Graph 1
		MyGNode N1 = new MyGNode("1");
		MyGNode N2 = new MyGNode("2", N1);
		N1.addChild(N2);
	
		//Print Walk for Graph 1
		System.out.println("Walk 1:");
		for(GNode temp : N1.walkGraph(N1))
			System.out.print(temp.getName());
	
		//Print Path for Graph 1
		System.out.println("\n\nPaths 1:");
		for(ArrayList<GNode> temp : N1.paths(N1)){
			for(GNode node : temp)
				System.out.print(node.getName() + " ");
			System.out.println();
		}//for
		
		System.out.println();
	
		//Creates GNodes for Graph 2
		MyGNode A = new MyGNode("A");
		MyGNode B = new MyGNode("B", A);
		A.addChild(B);
		MyGNode C = new MyGNode("C");
		MyGNode D = new MyGNode("D", A);
		A.addChild(D);
		MyGNode E = new MyGNode("E");
		MyGNode F = new MyGNode("F", A);
		A.addChild(F);
		MyGNode G = new MyGNode("G", C);
		C.addChild(G);
		MyGNode H = new MyGNode("H", C, F);
		C.addChild(H);
		F.addChild(H);
		MyGNode I = new MyGNode("I", F);
		F.addChild(I);
		MyGNode J = new MyGNode("J", D, E);
		D.addChild(J);
		E.addChild(J);
		MyGNode K = new MyGNode("K", A);
		A.addChild(K);
		MyGNode L = new MyGNode("L", J);
		J.addChild(L);
		MyGNode M = new MyGNode("M", E);
		E.addChild(M);
		MyGNode N = new MyGNode("N", G);
		G.addChild(N);
	
		//Prints Walk for Graph 2
		System.out.println("Walk 2:");
		for(GNode temp : A.walkGraph(A))
			System.out.print(temp.getName());
	
		//Prints Path for Graph 2 A
		System.out.println("\n\nPaths 2 starting at A:");
		for(ArrayList<GNode> temp : A.paths(A)){
			for(GNode node : temp)
				System.out.print(node.getName() + " ");
			System.out.println();
		}//for
		
		//Prints Path for Graph 2 from G
		System.out.println("\n\nPaths 2: Starting at G");
		for(ArrayList<GNode> temp : G.paths(G)){
			for(GNode node : temp)
				System.out.print(node.getName() + " ");
			System.out.println();
		}//for
	
	}//main

}//Test
