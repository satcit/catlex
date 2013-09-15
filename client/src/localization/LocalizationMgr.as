package localization {
	import flash.net.FileReference;
	import flash.net.URLLoader;
	
	import mx.collections.ArrayList;

  /**
  * My localization realization is based on the fact that all String constants in code 
  * have unicue ID in localization file. So if we want to replase initial word/phrase with
  * word/phrase in another language we go here and look for an ID of the word/phrase.
  * If we find it then we go to a new localization file and retrieve word/phrase by ID.
  */
	public final class LocalizationMgr	{
		private var instance:LocalizationMgr;
		private var currentLocaleUrl:String;
		
		public function LocalizationMgr() {
			if( instance != null ){
				throw Error( "Singleton class. Use instance() method");
			}
		}
		
		public static function get instance():LocalizationMgr {
		  if( insance == null ) {
		    instance = new LocalizationMgr();
		  }
		  return instance;
		}
		
    /**
    * 
    */ 
		public static function getValue( id:int ):String {
      
		}
    
    /**
    * Should return a list of Files/Urls to all localization files
    */
    private function getLocalizationFiles():ArrayList {
      // here should be 
    }
	}
}