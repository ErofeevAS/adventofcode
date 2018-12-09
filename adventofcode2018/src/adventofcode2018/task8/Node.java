package adventofcode2018.task8;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String name;
	private int childrens;
	private int metaBytes;
	private List<Integer> data = new ArrayList<Integer>();

	public void add(int data) {
		this.data.add(data);
	}

	
	public Node(String name, int childrens, int metaBytes) {
		super();
		this.name = name;
		this.childrens = childrens;
		this.metaBytes = metaBytes;
	}


	public Node(int childrens, int metaBytes) {
		super();
		this.childrens = childrens;
		this.metaBytes = metaBytes;
	}

	public int getChildrens() {
		return childrens;
	}

	public void setChildrens(int childrens) {
		this.childrens = childrens;
	}

	public int getMetaBytes() {
		return metaBytes;
	}

	public void setMetaBytes(int metaBytes) {
		this.metaBytes = metaBytes;
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
