package com.divya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;
 
    @Column(name = "sname")
    private String sname;
 
    @Column(name = "cid")
    private String cid;
 
    @Column(name = "cname")
    private String cname;
    
    public Student() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Student(long sid, String sname, String cid, String cname, String elect, int sem, String book_issued,
			String doi) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.cid = cid;
		this.cname = cname;
		this.elect = elect;
		this.sem = sem;
		this.book_issued = book_issued;
		this.doi = doi;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getElect() {
		return elect;
	}
	public void setElect(String elect) {
		this.elect = elect;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public String getBook_issued() {
		return book_issued;
	}
	public void setBook_issued(String book_issued) {
		this.book_issued = book_issued;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	@Column(name="elect")
	String elect;
	
    @Column(name="sem")
	int sem;
	@Column(name="book_issued")
	String book_issued;
	@Column(name="doi")
	String doi;
	

}
