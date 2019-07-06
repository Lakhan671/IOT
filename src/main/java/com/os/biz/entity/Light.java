package com.os.biz.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Lakhan
 *
 */
@Document(collection = "light")
public class Light implements Serializable {
	private static final long serialVersionUID = 8707228725292197944L;
	@Id
	private String id;
	private Boolean onOff;
	private String type;
	private String lightLocation;
	private String latitude;
	private String longitude;
	private String userId;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the onOff
	 */
	public Boolean getOnOff() {
		return onOff;
	}

	/**
	 * @param onOff the onOff to set
	 */
	public void setOnOff(Boolean onOff) {
		this.onOff = onOff;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the lightLocation
	 */
	public String getLightLocation() {
		return lightLocation;
	}

	/**
	 * @param lightLocation the lightLocation to set
	 */
	public void setLightLocation(String lightLocation) {
		this.lightLocation = lightLocation;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
