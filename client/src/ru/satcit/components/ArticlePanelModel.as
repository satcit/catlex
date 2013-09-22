package ru.satcit.components
{
  import ru.satcit.data.Article;
  import ru.satcit.skins.ArticlePanelSkin;
  
  import spark.components.Panel;
  
  public class ArticlePanelModel extends Panel
  {
    [Bindable]
    public var data:Article;
    [Bindable]
    public var ratingVisible:Boolean;
    
    public function ArticlePanelModel( data:Article )
    {
      super();
      setStyle( "skinClass", Class( ArticlePanelSkin ));
      this.title = data.title;
      this.data = data;
    }
    
    [Bindable]
    public function get rating():Number {
      return data.rating;
    }
    
    public function set rating( rating:Number ) : void {
      data.rating = rating;
    }
  }
}