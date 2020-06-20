package sistema;

import java.util.List;

public class TratamentoDeString {
	
	public Boolean tratarString(String novaLinha, List<String> arquivo) {
		if(arquivo.contains(novaLinha)) {
			return true;
		}
		return false;
	}

}
