package dataStrucures;

//import java.util.*;
//import sun.java2d.*;



@SuppressWarnings({"unused" })
public class dataDoubleList{
	
	//public static void main(String[] args){
		
		
	//}
	
	/**
	 * @uml.property  name="First"
	 */
	private dataListNode firstNode = null;

	/**
	 * Getter of the property <tt>First</tt>
	 * @return  Returns the first.
	 * @uml.property  name="First"
	 */
	public dataListNode getFirstNode() {
		return firstNode;
	}
	//==============================================
	public void setFirstNode(dataListNode first) {
		this.firstNode = first;
	}

	/**
	 * @uml.property  name="Last"
	 */
	//============================================
	private dataListNode lastNode = null;

	/**
	 * Getter of the property <tt>Last</tt>
	 * @return  Returns the last.
	 * @uml.property  name="Last"
	 */
	//=================================
	public dataListNode getLastNode() {
		return lastNode;
	}


	public void setLastNode(dataListNode last) {
			this.lastNode = last;
	}

	/**
	 * @uml.property  name="Current"
	 * 
	 */
	//================================================
	private dataListNode currentNode = null;

	
	public dataListNode getCurrentNode() {
		return currentNode;
	}

	
	public void setCurrentNode(dataListNode current) {
		this.currentNode = current;
	}

	/**
	 * @uml.property  name="Count"
	 */
//===========================================
	private int nodeCount = 0;

	/**
	 * Getter of the property <tt>Count</tt>
	 * @return  Returns the count.
	 * @uml.property  name="Count"
	 */
	//========================================
	public int getNodeCount() {
		return this.nodeCount;
	}

	
	public void setNodeCount(int count) {
		this.nodeCount = count;
	}
	//=======================end setters and getters==============================
	
	//====================================edit node==============================
	/*public void editNode(String device, String type, String mac, String serial, String location, String comments, dataListNode editNode){
		 editNode.setDevice(device);
		 editNode.setType(type);
		 editNode.setMacAddress(mac);
		 editNode.setSerial(serial);
		 editNode.setLocation(location);
		 editNode.setComments(comments);
		
		
	}*/
	//=========================================================================================

//===================================================================
public void insertNode(dataListNode newNode, dataListNode afterNode){
	if(afterNode != null){
		 newNode.setPrevious(afterNode.getPrevious());
		 newNode.setNext(afterNode);
		 afterNode.getPrevious().setNext(newNode);
		 afterNode.setPrevious(newNode);
		 setNodeCount(getNodeCount() + 1);
		 setCurrentNode(newNode);
	}
}
//====================================================================
public void insertNode(dataListNode newNode){	//System.out.println("in insert node");
	if(getFirstNode() == null){
		 setFirstNode(newNode);
		 setLastNode(newNode);
		 newNode.setNext(newNode);
		 newNode.setPrevious(newNode);
		 setNodeCount(getNodeCount() + 1);			 
		 setCurrentNode(newNode);
	 }
	else if(getFirstNode().equals(getLastNode())){
		 newNode.setPrevious(getFirstNode());
		 newNode.setNext(getFirstNode());
		 setLastNode(newNode);
		 getFirstNode().setNext(newNode);
		 getFirstNode().setPrevious(getLastNode());
		 setNodeCount(getNodeCount() + 1);
		 setCurrentNode(newNode);
	 }
	else if(getLastNode() != null){
	 newNode.setPrevious(getLastNode());
	 newNode.setNext(getLastNode().getNext());
	 getLastNode().setNext(newNode);
	 getFirstNode().setPrevious(newNode); 
	 //if(getLastNode().equals(getFirstNode())){
		 setLastNode(newNode);			
	 //}
	 setNodeCount(getNodeCount() + 1);
	 setCurrentNode(newNode);
}
}	
	
	//========================================================================================
		
//=========================================== end insert node============================	
	public void removeNode(dataListNode ghostNode){
		dataListNode prev = ghostNode.getPrevious();
	if(getNodeCount() >= 1){
			ghostNode.getPrevious().setNext(ghostNode.getNext());
			ghostNode.getNext().setPrevious(prev);
			ghostNode.setNext(null);
			ghostNode.setPrevious(null);
			setNodeCount(getNodeCount() - 1);
	}
	else{
		setCurrentNode(null);
		setFirstNode(null);
		setLastNode(null);
		setNodeCount(0);
	}
	
	}


}
