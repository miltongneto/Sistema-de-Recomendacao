package tarefa1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {
	
	private IndexWriter writer;

	public Indexer(String indexDirectoryPath) {
		Path path = Paths.get(indexDirectoryPath);
		try {
			Directory indexDirectory = FSDirectory.open(path);
//			BrazilianAnalyzer analyser = new BrazilianAnalyzer();
//			analyser = new BrazilianAnalyzer(new CharArraySet(0, true));
			StandardAnalyzer analyzer = new StandardAnalyzer(new CharArraySet(Collections.emptyList(), true));
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			writer = new IndexWriter(indexDirectory, config);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	private Document getDocument(File file) throws IOException {
	   // FileInputStream arquivo = new FileInputStream(file);
	    
		Document document = new Document();
		
		// index file contents
		Field contentField = new Field("contents", new FileReader(file), TextField.TYPE_NOT_STORED);
		// index file name
		Field fileNameField = new Field("fieldname",file.getName(), TextField.TYPE_STORED);
		// index file path
		Field filePathField = new Field("filepath", file.getCanonicalPath(), TextField.TYPE_STORED);

		document.add(contentField);
		document.add(fileNameField);
		document.add(filePathField);
		
		
		return document;
	}
	
	public void indexFile(File file) throws IOException {
		Document document = getDocument(file);
		writer.addDocument(document);
	}

	public int createIndex(String FilesPath) throws IOException {
		// Pega todos os arquivos do diretorio
		File[] files = new File(FilesPath).listFiles();

		for (File file : files) {
			if (!file.isDirectory() && !file.isHidden() && file.exists() && file.canRead()) {
				indexFile(file);
			}
		}
		return writer.numDocs();
	}
	
	public void close() throws IOException {
		writer.close();
	}

}
