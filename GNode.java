import java.util.ArrayList;

/**
 * GNode is an interface to implment of a Graph's Node.
 */
public interface GNode{

	public String getName();
	public GNode[] getChildren();
	public ArrayList<GNode> walkGraph(GNode parent);
	public ArrayList<ArrayList<GNode>> paths(GNode parent);

}//GNode
