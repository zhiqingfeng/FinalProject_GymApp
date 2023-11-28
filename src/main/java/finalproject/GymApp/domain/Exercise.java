package finalproject.GymApp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;



@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	private String name;
	@Size(min=10, max=1000)
	private String description;
	private String duration;
	private String time;
	private String date;
	private String teacher;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Exercise() {}

	public Exercise(String name, String description, String duration, String time, String date, String teacher,
			Category category) {
		super();
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.time = time;
		this.date = date;
		this.teacher = teacher;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", description=" + description + ", duration=" + duration
				+ ", time=" + time + ", date=" + date + ", teacher=" + teacher + "]";
	}

	
}
