package com.seven7.insurance.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.File;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by FANFAN on 2017/6/10.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Table
public class UploadingLog extends AbstractPersistable implements Serializable {

    private User uploadedBy;

    private DateTime uploadDateTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "uploading")
    private Set<FeedFile> feedFiles;
}
