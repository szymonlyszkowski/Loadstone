#Loadstone
**My Bacherol Thesis**

##Dependencies:
There are 2 dependencies which are required to build jar correctly. They are not included in maven repository. You have to add za directory to your local maven repository.
In linux you can just type:
	
	mv za/ ~/.m2/repository/

###Processing scripts:

/SQLiteBuildScripts/**createDB.sh** - script utility for processing .txt file from website <http://gps.zlotowicz.pl/> . Creates SQLite database.

Example:

	chmod +x createDB.sh
    
	createDB.sh /directory/to/txt/file/cala_polska.txt


/SQLiteBuildScripts/**analyzeDB.sh** - script utility for analyzing .txt file which computes what phrases were the most frequent occuring in file. Returns phrases with number of occurences.

Example:

	chmod +x analyzeDB.sh
    
	analyzeDB.sh /directory/to/txt/file/cala_polska_poi.txt
	
	
###Getting start:
To access loadstone sqlite database:

	ObjectModel<TotalData, ResultSet, HashMap<String, Object>> model = LoadstoneDatabase.getLoadstoneSingleton();
        System.out.println(model.getAll().get(1).toString());
        
This will print out first row in the database.


