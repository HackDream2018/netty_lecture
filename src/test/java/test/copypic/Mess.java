package test.copypic;

public class Mess {
	String name;
	String date;
	String explanation;
	public Mess(){}
	public Mess(String name,String date,String explanation){
		this.name=name;
		this.date=date;
		this.explanation=explanation;
	}
	public Mess(String name,String date){
		this.name=name;
		this.date=date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	} 
	
}
