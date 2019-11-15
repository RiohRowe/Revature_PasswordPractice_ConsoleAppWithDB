package DBInterface.model;

import java.sql.Date;

/*
 * This is our movie model. It is a Java class that models some real-world data.
 */
public class Movie {

	/*
	 * It is good practice to make your fields match the columns of the table/entity
	 * on the DB side.
	 */
	private int id;
	private String title;
	private Date release_year;
	
	public Movie() {
		super();
	}
	
	public Movie(int id, String title, Date release_year) {
		super();
		this.id = id;
		this.title = title;
		this.release_year = release_year;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getRelease_year() {
		return release_year;
	}

	public void setRelease_year(Date release_year) {
		this.release_year = release_year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((release_year == null) ? 0 : release_year.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		if (release_year == null) {
			if (other.release_year != null)
				return false;
		} else if (!release_year.equals(other.release_year))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", release_year=" + release_year + "]";
	}
}
