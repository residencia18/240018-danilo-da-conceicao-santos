package danilo.buildrun.springsecurity.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tweets")
public class Tweet {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "tweet_id")
	private Long roleId;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User user;
	
	private String content;
	
	private Instant CreationTimestamp;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreationTimestamp() {
		return CreationTimestamp;
	}

	public void setCreationTimestamp(Instant creationTimestamp) {
		CreationTimestamp = creationTimestamp;
	}
	
	
	
}
