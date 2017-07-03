package tarefa1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Main {
	
	private static void busca(String indexPath) throws IOException{
		Path path = Paths.get(indexPath);
		Directory indexDirectory = FSDirectory.open(path);
		DirectoryReader dReader = DirectoryReader.open(indexDirectory);
		IndexSearcher indexSearcher = new IndexSearcher(dReader);
		Term term = new Term("contents","julgament");
		Query termQuery = new TermQuery(term);	
		TopDocs topDocs = indexSearcher.search(termQuery,10);

		ScoreDoc[] docs = topDocs.scoreDocs;
		
		for(ScoreDoc scoreDoc : docs) {
			Document doc = indexSearcher.doc(scoreDoc.doc);
			System.out.println(doc.getField("fieldname"));
		}
	}
	
	

	public static void main(String[] args) {
		String dir = "C:\\Users\\Milton\\Documents\\Mineração Web\\Tarefa 1\\index";
//		Indexer indexer = new Indexer(dir);
//		int numIndexed;
//		
//		try {
//			numIndexed = indexer.createIndex("C:\\Users\\Milton\\Documents\\Mineração Web\\Tarefa 1\\documentos");
//			indexer.close();
//			System.out.println(numIndexed);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			busca(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
