package model;
import java.io.FileOutputStream;
import java.io.Serializable;

public class Document implements Serializable {
	
	private String author;
	private String date;
	private String copyright;
	private int VersionID;
	private String Contents;
	private String type;
	private String location;
	
	public Document(String cont,String tp)
	{
		author="N/A";
		date = "N/A";
		copyright= "N/A";
		VersionID=0;
		Contents=cont;
		type=tp;
		//location=loc;
	}
	
	public Document(String auth,String dt,String cp,String type,String cont,String tp) {
		author=auth;
		date=dt;
		copyright=cp;
		VersionID=0;
		Contents=cont;
		type=tp;
		
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public int getVersionID() {
		return VersionID;
	}
	public void setVersionID(int versionID) {
		VersionID = versionID;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Document cloneDeep() {
		return new Document(new String(this.Contents),new String(this.type));
	}
	
	public void Save(String location) {
		 try{    
             FileOutputStream fout=new FileOutputStream(location);    
              
             byte b[]=Contents.getBytes();//converting string into byte array    
             fout.write(b);    
             fout.close();    
             //System.out.println("success...");    
            }catch(Exception e){System.out.println(e);}        
		
	}

}
