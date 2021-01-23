package com.galvanize.guestbook.model;

public class GuestBook {

    private String guestName;
    private String comments;
    private String id;

    
    public GuestBook() {
		super();
	}

	public GuestBook(String guestName, String comments) {
        this.guestName = guestName;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
