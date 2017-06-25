package com.seven7.insurance.feed.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.seven7.insurance.domain.AbstractPersistable;

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
@EntityListeners(AuditingEntityListener.class)
public class FeedFile extends AbstractPersistable implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1514359090279842696L;

    enum FileType {
        TEXT("txt"), EXCEL("xls", "xlsx"), PDF("pdf"), WORD("doc", "docx");

        private final List<String> suffixes;

        FileType(String... suffixStrings) {
            suffixes = new ArrayList<String>();

            if (ArrayUtils.isNotEmpty(suffixStrings)) {
                for (String sufix : suffixStrings) {
                    suffixes.add(StringUtils.lowerCase("." + StringUtils.trim(sufix)));
                }
            }
        }

        public static FileType getType(String suffix) {
            for (FileType type : FileType.values()) {
                if (type.suffixes.contains(StringUtils.lowerCase(StringUtils.trim(suffix)))) {
                    return type;
                }
            }
            return TEXT;
        }

    }

    private String fileName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @CreatedBy
//    @JsonIgnore
//    private User uploadedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Calendar uploaded;

    private String type;

    @Type(type = "org.hibernate.type.TrueFalseType")
    private Boolean active;

    public static FeedFile from(MultipartFile file) {

        FeedFile feed = new FeedFile();

        String fileName = file.getOriginalFilename(), suffix = fileName.substring(fileName.lastIndexOf("."));

        feed.setActive(true);
        feed.setFileName(fileName);
        feed.setType(StringUtils.lowerCase(FileType.getType(suffix).name()));
//        feed.setUploaded(Calendar.getInstance());

        return feed;
    }
    
//    @JsonInclude
//    public String getUploadedByUser(){
//    	return getUploadedBy().getUsername();
//    }
}
