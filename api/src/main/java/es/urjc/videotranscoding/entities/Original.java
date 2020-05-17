package es.urjc.videotranscoding.entities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "original")
public class Original {
	public interface Basic {
	}

	public interface Details {
	}

	public interface None {
	}

	/**
	 * VideoConversion id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Basic.class)
	private long originalId;
	/**
	 * Name of the video
	 */
	@JsonView(Basic.class)
	@Column(unique = true)
	private String name;
	/**
	 * Path of the video
	 */
	@Column(unique = true)
	@JsonView(Basic.class)
	private String path;
	/**
	 * User of the video
	 */
	@JsonView(None.class)
	private String user;
	/**
	 * Filesize of the original Video
	 */
	@JsonView(Basic.class)
	private String fileSize;

	/**
	 * All Conversions of the video
	 */
	@JsonView(Details.class)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "parent")
	private List<Conversion> conversions = new ArrayList<>();

	/**
	 * If all conversions are complete true, EOC false
	 */
	@JsonView(Basic.class)
	private boolean complete;
	/**
	 * If any conversion is active this is active;
	 */
	@JsonView(Basic.class)
	private boolean active;
	
	

	/**
	 * Constructor protected for hibernate.
	 */
	protected Original() {
	}

	/**
	 * Constructor for the Original vide
	 * 
	 * @param video
	 *            name of the video
	 * @param path
	 *            of the video
	 * @param user
	 *            user for the video
	 */
	public Original(String name, String path, String user) {
		this.name = name;
		this.path = path;
		this.user = user;

	}

	public boolean isComplete() {
		for (Conversion conversionVideo : conversions) {
			if (!conversionVideo.isFinished()) {
				return false;
			}
		}
		return true;
	}

	public boolean isActive() {
		for (Conversion conversionVideo : conversions) {
			if (conversionVideo.isActive()) {
				return true;
			}
		}
		return false;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Conversion> getAllConversions() {
		return conversions;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String getUserVideo() {
		return user;
	}

	public void setUserVideo(String userVideo) {
		this.user = userVideo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setAllConversions(List<Conversion> conversions) {
		this.conversions = conversions;
	}

	public Long getOriginalId() {
		return originalId;
	}

	public void removeConversion(Conversion c) {
		this.conversions.remove(c);
	}

	public String getFileSize() {
		return (getSizeMB(new File(getPath())) + " MB").replace(",", ".");
	}

	private String getSizeMB(File f) {
		double fileSizeInBytes = f.length();
		double fileSizeInKB = fileSizeInBytes / 1024;
		double fileSizeInMB = fileSizeInKB / 1024;
		return String.format("%.2f", fileSizeInMB);
	}

}
