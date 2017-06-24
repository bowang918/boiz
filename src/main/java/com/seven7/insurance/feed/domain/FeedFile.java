package com.seven7.insurance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by FANFAN on 2017/6/10.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Table
public class FeedFile extends AbstractPersistable implements Serializable {

    enum FileType{
        EXCEL,PDF,WORD
    }

    private String fileName;

    @JsonIgnore
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    private User uploadedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    private UploadingLog uploading;

    private DateTime uploaded;

    private FileType type;

    @Type(type = "org.hibernate.type.TrueFalseType")
    private Boolean active;

    @JsonInclude
    public String getGroup(){
        return "";
    }

    @JsonInclude
    public String getUrl(){
        return "";
    }
}
