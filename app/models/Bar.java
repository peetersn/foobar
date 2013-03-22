package models;

import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Bar extends Model {

    @Id
    public String id;

    public String name;

    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date openingDate = new Date();

    public static Finder<String,Bar> find = new Finder<String,Bar>(
            String.class, Bar.class
    );

}
