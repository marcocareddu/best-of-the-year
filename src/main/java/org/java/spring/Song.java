package org.java.spring;

public class Song {
	private int id;
	private String title;

	public Song(int id, String title) {
		setId(id);
		setTitle(title);
	}
	
//	Getters
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	
//	Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}