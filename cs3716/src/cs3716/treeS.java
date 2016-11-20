package cs3716;

public class treeS {
	treeS left;
	treeS right;
	private treeS parent;
	//team at each stage 
	team data;
	
	public treeS(treeS left, treeS right, treeS parent, team item) {
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.data = item;
	}
	//standard constructor
	public treeS(){
		this.left = null;
		this.right = null;
		this.parent = null;
		this.data = null;
	}

	public treeS getLeft() {
		return left;
	}

	public void setLeft(treeS left) {
		this.left = left;
	}

	public treeS getRight() {
		return right;
	}

	public void setRight(treeS right) {
		this.right = right;
	}

	public treeS getParent() {
		return parent;
	}

	public void setParent(treeS parent) {
		this.parent = parent;
	}

	public team getData() {
		return data;
	}

	public void setData(team data) {
		this.data = data;
	}
}
