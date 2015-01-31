package com.newtechfellas.videotutorials.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 1/30/15.
 * Time: 10:27 PM
 */
@Entity
public class SubscribedUserEntity {

    @Id
    private Long id; //auto generated

    @NotEmpty
    private String email;

    private String name; //optional user name to address in subscription emails

    @Index
    @NotEmpty
    private List<String> subscriptionCategories = new ArrayList<>();

    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date subscribedDate;
}
