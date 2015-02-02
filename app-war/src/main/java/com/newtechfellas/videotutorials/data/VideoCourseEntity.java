package com.newtechfellas.videotutorials.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/30/15.
 * Time: 10:17 PM
 */
@Entity
public class VideoCourseEntity {

    @Id
    private Long id;//auto generated

    @Index
    private VideoType videoType;

    @NotEmpty
    private String provider; //youtube/infoq etc

    @Index
    @NotEmpty
    private String technology; //Hibernate, Wicket, JSP etc

    @Index
    @NotEmpty
    private String category; //java/.Net/SQL etc


    private List<EpisodeDetails> videos = new ArrayList<>();

    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date lastModified;

    //could be a fast paced overview video or a detailed video lessons series
    public static enum VideoType {
        OVERVIEW,
        COURSE
    }

    public static class EpisodeDetails {
        @NotEmpty
        private String link; //video link

        @NotEmpty
        @Index
        private String title; //video title

        private Map<String, String> imageLinks; //image links of various resolutions (mobile, tablet, desktop etc)

        private boolean allowedToEmbed = false; //can the video to be embeded in the same page

        private String embedLink;

        public String getEmbedLink() {
            return embedLink;
        }

        public void setEmbedLink(String embedLink) {
            this.embedLink = embedLink;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Map<String, String> getImageLinks() {
            return imageLinks;
        }

        public void setImageLinks(Map<String, String> imageLinks) {
            this.imageLinks = imageLinks;
        }

        public boolean isAllowedToEmbed() {
            return allowedToEmbed;
        }

        public void setAllowedToEmbed(boolean allowedToEmbed) {
            this.allowedToEmbed = allowedToEmbed;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VideoType getVideoType() {
        return videoType;
    }

    public void setVideoType(VideoType videoType) {
        this.videoType = videoType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<EpisodeDetails> getVideos() {
        return videos;
    }

    public void setVideos(List<EpisodeDetails> videos) {
        this.videos = videos;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
}