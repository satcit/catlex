package ru.satcit.data
{
  [Bindable]
  public class Article extends Object
  {
    public var id:int;
    public var title:String;
    public var content:String;
    public var rating:Number;
    public var creationDate:Number;
    public var modificationDate:Number;
    
    public function Article()
    {
      super();
    }
  }
}