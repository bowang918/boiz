package com.seven7.insurance.feed.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seven7.insurance.domain.AbstractPersistable;
import com.seven7.insurance.domain.User;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by FANFAN on 2017/6/10.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Table
public class FeedFile extends AbstractPersistable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1514359090279842696L;

	enum FileType {
		EXCEL, PDF, WORD
	}

	private String fileName;

	@ManyToOne(fetch = FetchType.LAZY)
	private User uploadedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar uploaded;

	private String type;

	@Type(type = "org.hibernate.type.TrueFalseType")
	private Boolean active;

	@JsonInclude
	public String getGroup() {
		return "";
	}

	@JsonInclude
	public String getUrl() {
		return "";
	}

	public static FeedFile from(MultipartFile file) {

		FeedFile feed = new FeedFile();

		String fileName = file.getOriginalFilename();

		feed.setActive(true);
		feed.setFileName(fileName);
		feed.setType((StringUtils.upperCase(fileName.substring(fileName.lastIndexOf(".") + 1))));
		feed.setUploaded(Calendar.getInstance());

		return feed;
	}
}
