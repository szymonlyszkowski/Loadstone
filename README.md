## Loadstone
**My Bacherol Thesis**

###Processing scripts:

/SQLiteBuildScripts/**createDB.sh** - script utility for processing .txt file from website <http://gps.zlotowicz.pl/> . Creates SQLite database.

Example:

	chmod +x createDB.sh
    
	createDB.sh /directory/to/txt/file/cala_polska.txt


/SQLiteBuildScripts/**analyzeDB.sh** - script utility for analyzing .txt file which computes what phrases were the most frequent occuring in file. Returns phrases with number of occurences.

Example:

	chmod +x analyzeDB.sh
    
	analyzeDB.sh /directory/to/txt/file/cala_polska_poi.txt


