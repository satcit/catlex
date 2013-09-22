package ru.satcit.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import ru.satcit.data.db.Article;
import ru.satcit.data.xml.ArticleListXml;
import ru.satcit.data.xml.ArticleXml;

@Path( value = "/articles" )
public class ArticleService {
  @Context
  private HttpServletRequest request;

  @Path( "{id}" )
  @GET
  @Produces( MediaType.APPLICATION_JSON )
  public ArticleXml getArticle( @PathParam( value="id" ) int id ) {
    return readArticle( id );
  }

  @GET
  @Produces( MediaType.APPLICATION_JSON )
  public ArticleListXml getArticles() {
    return getAllArticles();
  }

  @POST
  @Path( "{id}" )
  public void createArticle( @PathParam(value = "id") int id ) {

  }

  @SuppressWarnings("unchecked")
  private ArticleXml readArticle( int id ) {
    // TODO move entity name to constant
    try {
      Class.forName( "com.mysql.jdbc.Driver" );
    } catch ( ClassNotFoundException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    EntityManagerFactory factory = Persistence.createEntityManagerFactory( "catlex" );
    EntityManager manager = factory.createEntityManager();
    Query query = manager.createQuery( "SELECT a FROM Article a WHERE a.id=" + id, Article.class );
    try{
      for( Article article : (List<Article>)query.getResultList() ) {
        return new ArticleXml( article );
      }
    return null;
    } finally {
      manager.close();
      factory.close();
    }
  }

  @SuppressWarnings("unchecked")
  private ArticleListXml getAllArticles() {
    // TODO move entity name to constant
    EntityManagerFactory factory = Persistence.createEntityManagerFactory( "catlex" );
    EntityManager manager = factory.createEntityManager();
    Query query = manager.createQuery( "SELECT a FROM Article a" );
    ArticleListXml list = new ArticleListXml();
    try{
      for( Article article : (List<Article>)query.getResultList() ) {
        list.getArticles().add( new ArticleXml( article ) );
      }
    return list;
    } finally {
      manager.close();
      factory.close();
    }
  }

  private void writeArticle( Article article ) {

  }
}
