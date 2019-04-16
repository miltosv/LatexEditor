package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class DocumentManager {
	private int ID=0;
	private int CONTENTS=1;
	HashMap<String,Document> map=new HashMap<String,Document>();
	
	public DocumentManager() {
		
		dynamicallyCreateDocuments("src\\model\\templates.txt");
		
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
				System.out.println("doctype  "+key+"  created");
				//System.out.println("doctype   "+contents+"   created");
				
				
			}
			DocumentSpecsReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Document createDocument(String type) {
		Document doc=map.get(type);
		System.out.println("doc  "+type+"  created");
		return doc.cloneDeep();
		
	}
	
}
