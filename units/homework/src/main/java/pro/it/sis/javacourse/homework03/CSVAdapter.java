package pro.it.sis.javacourse.homework03;

import java.io.IOException;

public interface CSVAdapter<TObject extends CSVObject>  {
	TObject read(Integer rowNum) throws IOException, IllegalAccessException, InstantiationException;

	Integer append(TObject object) throws IOException;

}
