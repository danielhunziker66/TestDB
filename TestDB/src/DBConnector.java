import java.util.ArrayList;
import java.util.List;


public class DBConnector {
		private List<String> listemitNamen = new ArrayList<String>();
		
		DBConnector(){

		}
		
		public void addDaten(String name) {
			listemitNamen.add(name);
		}
		
		public List<String> getDaten() {
				
			return listemitNamen;
		}
}
