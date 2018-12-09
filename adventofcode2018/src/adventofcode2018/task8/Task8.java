package adventofcode2018.task8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adventofcode2018.FileReader;

public class Task8 {

	List<Node> nodes = new ArrayList<Node>();
	int summ = 0;
	int classCounter = -1;
	int index = 0;
	char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	int[] data;

	private void init(String fileName) throws IOException {
		String[] dataIn = FileReader.readFromFile(fileName);

		String[] fields = dataIn[0].split("\\s+");
		data = new int[fields.length];
		for (int i = 0; i < fields.length; i++) {
			data[i] = Integer.parseInt(fields[i]);
		}
	}

	public Node getNodes() {
		classCounter++;
		String clasName = classCounter + "";
		int childs = data[index];
		int meta = data[index + 1];
		int childsLeft = childs;

		Node node = new Node(clasName + "", childs, meta);

		while (childsLeft != 0) {
			index += 2;
			childsLeft--;
			///System.out.println("Создается новый  потомок: " + childsLeft + " класса: " + clasName);
			Node newnode = getNodes();
			nodes.add(newnode);
			//System.out.println("Возвращение потомка класса:" + clasName + " потомок: " + newnode.getName());		
		}

		for (int j = index + 2; j <= index + meta + 1; j++) {
			node.add(data[j]);
			summ += data[j];
		}
		index += meta;
		nodes.add(node);	
		return node;

	}

	public int getResult(String fileName) throws IOException {
		this.init(fileName);		
		nodes.add(getNodes());
		

		return summ;
	}

}
