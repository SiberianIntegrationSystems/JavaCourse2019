package pro.it.sis.javacourse.homework03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class CSVAdapterImpl<TObject extends CSVObject> implements CSVAdapter<TObject> {
	final private static int DEFAULT_BUFFER_SIZE = 9999;
	private Class objectClass;
	private BufferedReader reader;
	private BufferedWriter writer;

	public CSVAdapterImpl(Class objectClass, BufferedReader reader, BufferedWriter writer) {
		this.initAdapter(objectClass, reader, writer, DEFAULT_BUFFER_SIZE);
	}

	private void initAdapter(Class objectClass, BufferedReader reader, BufferedWriter writer, int bufferSize) {
		try {
			this.objectClass = objectClass;
			this.writer = writer;
			this.reader = reader;
			this.reader.mark(bufferSize);
		} catch (IOException ex) {
			throw new RuntimeException(ex.getLocalizedMessage());
		}
	}

	@Override
	public TObject read(Integer rowNum) {
		TObject obj;

		try {
			reader.reset();
			int rowCounter=0;
			String data = null;
			while ((data = reader.readLine()) != null)
			{
				if(rowCounter==rowNum){
					break;
				}
				rowCounter++;
			}
			obj = (TObject) objectClass.newInstance();

			System.out.println("READ(" + rowNum + "): " + data);

			obj.fillByCSV(data);
		} catch (IllegalAccessException | InstantiationException | IOException ex) {
			throw new RuntimeException(ex.getLocalizedMessage());
		}
		return obj;
	}

	@Override
	public Integer append(TObject object) {
		Integer rowNumber;
		try {
			String csv = object.toCSV();

			writer.newLine();
			writer.append(csv);
			writer.flush();

			rowNumber = getLastRowNumber();

			System.out.println("WRITE(" + rowNumber + "): " + csv);


		} catch (IOException ex) {
			throw new RuntimeException(ex.getLocalizedMessage());
		}
		return rowNumber;
	}

	private Integer getLinesCount() throws IOException {
		reader.reset();
		int rowCounter=0;
		String data = null;
		while ((data = reader.readLine()) != null)
		{
			rowCounter++;
		}
		return rowCounter;
	}

	private Integer getLastRowNumber() throws IOException {
		return getLinesCount() - 1;
	}
}
