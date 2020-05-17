package es.urjc.videotranscoding.codecs;

/**
 * Container Types for videos
 * 
 * @author luisca
 */
public enum Container {
	/**
	 * Mp4 extension
	 */
	MP4(".mp4"),
	/**
	 * Mkv extension
	 */
	MKV(".mkv"),
	/**
	 * Webm extension
	 */
	WEBM(".webm"),
	/**
	 * Avi extension
	 */
	AVI(".avi"),
	/**
	 * Flv extension
	 */
	FLV(".flv"),
	/**
	 * Mov extension
	 */
	MOV(".mov");
	final String containerType;

	Container(String x) {
		this.containerType = x;
	}

	public String toString() {
		return containerType;
	}
}
