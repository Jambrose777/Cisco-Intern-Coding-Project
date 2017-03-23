import java.util.ArrayList;

/**
 * MyGNode is my implementation of GNode. It gives a Graph a computer 
 * implementation with a Tree having all of its children given.
 */
public class MyGNode implements GNode{

	//variables
	private String name; //name of node
	private ArrayList<GNode> children = new ArrayList<GNode>(); //all the children of This node. Chose ArrayList as Java can effeciently handle Arrays of variable sizes whenever you use an ArrayList.

	/*
	 * Constructor MyGNode
	 * sets the variables for the object
	 * @param name is the name of the Node. Note no 2 nodes in a graph should have the same name
 	 * @param children is a list of the children to put in the children.
	 */
	public MyGNode(String name, GNode... children){
		this.name = name;
		for(GNode child : children){
			this.children.add(child);
		}//for
	}//MyGNode Constructor

	/*
	 * addChild
	 * adds a child to the list of children a node has
	 */
	public void addChild(GNode child){
		this.children.add(child);
	}//addChild

	/*
	 * getChildren 
 	 * @return GNode[] array of children
	 */
	public GNode[] getChildren(){
		int size = this.children.size(); //number of children
		GNode arr[] = new GNode[size]; //array of children
		//for to go threw each child and add to array.
		for(int i = 0; i < size; i++){
			arr[i] = this.children.get(i);
		}//for
		return arr;
	}//getChildren

	/*
	 * getName
	 * @return String the name of the GNode
	 */
	public String getName(){
		return name;
 	}//getName

	/*
	 * walkGraph
	 * reutrns an ArrayList containing everyGNode in the graph. Done recursively by having every child
	 * of the GNode return it's own WalkGraph excluding its parent.
	 * for the first iteration, we can set parent = the node calling the function.
	 * @param parent the parent of the node that calls walkGraph on the node.
	 * @return ArrayList<GNode> is a list of the walk from a node
	 */
	public ArrayList<GNode> walkGraph(GNode parent){
		ArrayList<GNode> walk = new ArrayList<GNode>(); //new walk array for this node
		//for each of the children, get their walk graph and add it to this node's walk
		for(GNode child : children){
			if(child.getName() != parent.getName())
				walk.addAll(child.walkGraph(this));
		}//for
		//add this node to the walk
		walk.add(this);
		return walk;
	}//walkGraph

	/*
	 * paths
 	 * returns all the paths from a given node. Adds the node itself to all the paths.
	 * @param parent is the node that called it's child. Set to the calling node for the 1st iteration
	 * @return ArrayList,ArrayList<GNode>> all the paths from a GNode
	 */
	public ArrayList<ArrayList<GNode>> paths(GNode parent){
		ArrayList<ArrayList<GNode>> list = new ArrayList<ArrayList<GNode>>(); //all the paths for this node
		//base case: see if 1st node to be added.
		if(children.size() == 0 
			|| (children.size() == 1 && parent.getName() == children.get(0).getName())){
			//create a list of a single list of this GNode
			list.add(new ArrayList<GNode>());
			list.get(0).add(this);
		}else{
			//add all the children's paths to the arrayList
			for(GNode child : children){
				if(child.getName() != parent.getName()){
					list.addAll(child.paths(this));
				}//if
			}//for
			//add the node itself to the Arraylist
			for(ArrayList<GNode> temp : list){
				temp.add(0, this);
			}//for
		}//if else
		return list;
	}//paths

}//MyGNode
