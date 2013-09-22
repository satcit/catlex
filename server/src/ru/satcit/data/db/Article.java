package ru.satcit.data.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="articles" )
public class Article {
  @Id
  @Column( name="article_id" )
  private int id;
  @Column( name = "creation_date" )
  private Date creationDate;
  @Column( name="modification_date" )
  private Date modificationDate;
  @Column( name="title" )
  private String title;
  @Column( name="content" )
  private String content;


  public int getId () {
    return id;
  }

  public void setId ( int id ) {
    this.id = id;
  }

  public String getTitle () {
    return title;
  }

  public void setTitle ( String title ) {
    this.title = title;
  }


  public String getContent () {
    return content;
  }

  public void setContent ( String content ) {
    this.content = content;
  }

  public Date getCreationDate () {
    return creationDate;
  }

  public void setCreationDate ( Date creationDate ) {
    this.creationDate = creationDate;
  }

  public Date getModificationDate () {
    return modificationDate;
  }

  public void setModificationDate ( Date modificationDate ) {
    this.modificationDate = modificationDate;
  }
}
