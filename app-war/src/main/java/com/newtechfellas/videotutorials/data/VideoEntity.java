package com.newtechfellas.videotutorials.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/30/15.
 * Time: 10:17 PM
 */
@Entity
public class VideoEntity {

    @Id
    private Long id;//auto generated

    @Index
    @NotEmpty
    private String name;

    @NotEmpty
    private String provider; //youtube/infoq etc

    @NotEmpty
    private String technology; //Hibernate, Wicket, JSP etc

    @NotEmpty
    private String category; //java/.Net/SQL etc

    @NotEmpty
    private String href; //video link

    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date createdUTC;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Date getCreatedUTC() {
        return createdUTC;
    }

    public void setCreatedUTC(Date createdUTC) {
        this.createdUTC = createdUTC;
    }
}
