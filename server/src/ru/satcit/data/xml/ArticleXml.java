package ru.satcit.data.xml;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ru.satcit.data.db.Article;

/**
 * I know, it is weird and Xml bindig should be in {@link ru.satcit.data.db.Article}
 * but it doesn't work for now.
 * @author black
 *
 */
@XmlRootElement
public class ArticleXml {
  private Article data;

  public ArticleXml() {
  }

  public ArticleXml( Article data ) {
    this.data = data;
  }

  @XmlElement
  public int getId () {
    return data.getId();
  }

  @XmlElement
  public String getTitle () {
    return data.getTitle();
  }


  @XmlElement
  public String getContent () {
    return data.getContent();
  }


  @XmlElement
  public Date getCreationDate () {
    return data.getCreationDate();
  }

  @XmlElement
  public Date getModificationDate () {
    return data.getModificationDate();
  }
}
