package sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Util {

	public static int retornaNumeroDiaSemana(String diaPadraoBR, boolean formatoBD) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date ontem = null;
		
		if(formatoBD) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");	
		}
		
        
		try {
			ontem = sdf.parse(diaPadraoBR);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(ontem);
        return gc.get(GregorianCalendar.DAY_OF_WEEK);
	}
	
	public static String retornaDiaExtenso(int numeroDia) {

		List<String> dias = new ArrayList<>();
		dias.add(0, "tabela");
		dias.add(1, "Domingo");
		dias.add(2, "Segunda-feira");
		dias.add(3, "Terca-feira");
		dias.add(4, "Quarta-feira");
		dias.add(5, "Quinta-feira");
		dias.add(6, "Sexta-feira");
		dias.add(7, "Sabado");
		return dias.get(numeroDia);
	
	}
	
	public static String perguntaAoUsuario(String pergunta) {
		Scanner scan = new Scanner(System.in);
	    System.out.println(pergunta);
	    String resposta = scan.next();
	    return resposta;
	}
}
