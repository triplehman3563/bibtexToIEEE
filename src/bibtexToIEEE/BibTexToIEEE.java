package bibtexToIEEE;

public class BibTexToIEEE {
	
	public String processBibTex(String s) {
		//1.	X. Kang, M. Azizian, E. Wilson, K. Wu, A.D. Martin, and
		//T.D. Kane, “Stereoscopic augmented reality for laparoscopic surgery,” Surg Endosc,
		//vol. 28, no. 7, pp. 2227-2235, 2014.
		String Temp = s;
		System.out.println(Temp);
		String author = detectKeyword("author", Temp);
		String title = detectKeyword("title", Temp);
		String journal =detectKeyword("journal", Temp);
		String volume =detectKeyword("volume", Temp);
		String number =detectKeyword("number", Temp);
		String pages =detectKeyword("pages", Temp);
		String year =detectKeyword("year", Temp);
		Data data = new Data(author, title, journal, volume, number, pages, year);
		
		String result = FormatingIEEE(data);
		System.out.println(result);
		return result;
		
	}
	
	static String detectKeyword(String keyword, String file) {
		String content=null;
		int keywordLength=keyword.length();
		int fileLength = file.length();
		for(int i = 0; i<fileLength- keywordLength + 1;i++) {
			String temp = file.substring(i, i + keywordLength);
			if (temp.compareTo(keyword)==0) {
				//keyword found
				//cut string from 2 step after index to 1 step before'\n'
				int steps = 0;
				int indexStart = i+keywordLength;
				int indexEnd = 0;
				while (true){
					String s =file.substring((i + keywordLength + steps + 2),
							(i + keywordLength + steps + 3));
					//System.out.println(""+s);
					if (file.substring((i + keywordLength + steps + 2),
							(i + keywordLength + steps + 3)).compareTo("\n")==0) {
						
						indexEnd = i + keywordLength + steps + 1;
						
						//System.out.println("break");
						break;
					}
					steps++;
					
					
				}
				
					//System.out.println("indexStart"+indexStart);
					//System.out.println("indexEnd"+indexEnd);
					content = file.substring(indexStart+2, indexEnd-1);
				//System.out.println("content: "+content);
			}
		}
		return content;
	}

	static String FormatingIEEE(Data data) {
		
		String result = null;
		
		result = ""+data.author+", "+'"'+data.title+'"'+", "+data.journal+", "+
		"vol. "+data.volume+", "+"no. "+data.number+", "+"pp. "+data.pages+", "+data.year
		;
		
		return result;
	}
	
	public class Data {
		String author;
		String title ;
		String journal ;
		String volume ;
		String number;
		String pages;
		String year;
		
		Data (String author,
		String title ,
		String journal ,
		String volume ,
		String number,
		String pages,
		String year){
			this.author = author;
			this.title = title;
			this.journal = journal;
			this.volume = volume;
			this.number = number;
			this.pages = pages;
			this.year = year;
		}

	}


}

