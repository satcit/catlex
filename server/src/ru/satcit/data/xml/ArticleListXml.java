package ru.satcit.data.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArticleListXml {
  private List< ArticleXml > articles = new ArrayList<>();

  @XmlElement( name="articles" )
  public List< ArticleXml > getArticles () {
    return articles;
  }
}
