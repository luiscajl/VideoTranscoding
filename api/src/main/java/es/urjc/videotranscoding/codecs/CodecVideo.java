package es.urjc.videotranscoding.codecs;

/**
 * Video codecs with qualities
 * 
 * @author luisca
 *
 */
public enum CodecVideo {
	/**
	 * 
	 */
	HEVC_2160(" -c:v libx265 -vf scale=3840:-2 -crf 15 -preset slow "),
	/**
	 * 
	 */
	HEVC_1080(" -c:v libx265 -vf scale=1920:-2 -crf 15 -preset slow "),
	/**
	 * 
	 */
	HEVC_720(" -c:v libx265 -vf scale=1280:-2 -crf 15 -preset slow "),
	/**
	 * 
	 */
	HEVC_480(" -c:v libx265 -vf scale=854:-2 -crf 15 -preset slow "),
	/**
	 * 
	 */
	HEVC_360(" -c:v libx265 -vf scale=640:-2 -crf 15 -preset slow "),
	/**
	 * 
	 */
	VP9_2160(" -c:v libvpx-vp9 -vf scale=3840:-2 -threads 4 -crf 30 -b:v 0 "),
	/**
	 * 
	 */
	VP9_1080(" -c:v libvpx-vp9 -vf scale=1920:-2 -threads 4 -crf 30 -b:v 0 "),
	/**
	 * 
	 */
	VP9_720(" -c:v libvpx-vp9 -vf scale=1280:-2  -threads 4 -crf 30 -b:v 0 "),
	/**
	 * 
	 */
	VP9_480(" -c:v libvpx-vp9 -vf scale=854:-2 -threads 4 -crf 30 -b:v 0 "),
	/**
	 * 
	 */
	VP9_360(" -c:v libvpx-vp9 -vf scale=640:-2 -threads 4 -crf 30 -b:v 0 "),
	/**
	 * 
	 */
	H264_1080(" -c:v libx264 -vf scale=1920:-2 -crf 18 -preset slow "),
	/**
	 * 
	 */
	H264_720(" -c:v libx264 -vf scale=1280:-2 -crf 18 -preset slow "),
	/**
	 * 
	 */
	H264_480(" -c:v libx264 -vf scale=854:-2 -crf 18 -preset slow "),
	/**
	 * 
	 */
	H264_360(" -c:v libx264 -vf scale=640:-2 -crf 18 -preset slow ");
	private final String codecVideoType;

	CodecVideo(String x) {
		this.codecVideoType = x;
	}

	@Override
	public String toString() {
		return codecVideoType;
	}
}
