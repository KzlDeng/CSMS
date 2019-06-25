package model;

/**
 * VCollegeScore entity. @author MyEclipse Persistence Tools
 */

public class VCollegeScore implements java.io.Serializable {
	private Integer collegeid;
	private String collegename;
	private Double scorenumber;
	private Double allscore;
	private Integer sportid;

	// Constructors

	/** default constructor */
	public VCollegeScore() {
	}

	/** full constructor */
	public VCollegeScore(Integer collegeid, String collegename,
			Double scorenumber, Double allscore, Integer sportid) {
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.scorenumber = scorenumber;
		this.allscore = allscore;
		this.sportid = sportid;
	}

	// Property accessors

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public Double getScorenumber() {
		return this.scorenumber;
	}

	public void setScorenumber(Double scorenumber) {
		this.scorenumber = scorenumber;
	}

	public Double getAllscore() {
		return this.allscore;
	}

	public void setAllscore(Double allscore) {
		this.allscore = allscore;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}
}