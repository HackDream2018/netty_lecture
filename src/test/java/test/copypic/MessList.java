package test.copypic;

import java.util.ArrayList;


public class MessList {
	String name;
	ArrayList<Mess> list;
	public MessList(){}
	public MessList(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Mess> getList() {
		return list;
	}
	public void setList(ArrayList<Mess> list) {
		this.list = list;
	}
	
}
