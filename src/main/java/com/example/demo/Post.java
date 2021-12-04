package com.example.demo;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int stats;
    @Column
    private String imgURL;
	@Column
    private String title;
	@Column
    private String punchLine;
	@Column
	private Long category;
   
	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}
	@Lob
    @Column
    private String content;
   
    

    
    public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
    
    public int getStats() {
		return stats;
	}

	public void setStats(int stats) {
		this.stats = stats;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getPunchLine() {
		return punchLine;
	}

	public void setPunchLine(String punchLine) {
		this.punchLine = punchLine;
	}
    
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post()
    {
    	
    }
	public Post(Long id,String imgURL, int stats, String title,String punchLine, String content, Long category) {
		super();
		this.id = id;
		this.imgURL=imgURL;
		this.stats=stats;
		this.title = title;
		this.punchLine=punchLine;
		this.content = content;
		this.stats = stats;
		this.category=category;
	}
    
    
}