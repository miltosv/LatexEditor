package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class DocumentManager {
	private static final int ID=0;
	private static final int CONTENTS=1;
	HashMap<String,Document> map=new HashMap<String,Document>();
	
	public DocumentManager() {
		
		dynamicallyCreateDocuments("templates.txt");
		
	}
	void dynamicallyCreateDocuments(String TemplateFilepath){
		
		try {
			BufferedReader DocumentSpecsReader = new BufferedReader(
					new FileReader (TemplateFilepath)
					);
			
			String currrentSpec;
			while ((currrentSpec = DocumentSpecsReader.readLine()) != null) {
				String keyStateConfigPair[] = currrentSpec.split(" ");
				String contents=(new String(readAllBytes(get(keyStateConfigPair[CONTENTS]))));
				String key=keyStateConfigPair[ID];
				map.put(key,new Document(contents,key));
				
				
			}
			DocumentSpecsReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	Document getDocument(String type) {
		Document doc=map.get(type);
		return doc.cloneDeep();
		
	}
	
}
