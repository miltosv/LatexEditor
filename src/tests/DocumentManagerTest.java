package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;
public class DocumentManagerTest {

	

	@Test
	public void testCreateDocument() {
		DocumentManager manager=new DocumentManager();
		Document doc=manager.createDocument("Article");
		assertNotNull(doc);
		
	}

}
