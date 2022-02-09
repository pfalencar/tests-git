package br.com.pfa.lista.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class ListaDatas {

	public static void main(String[] args) {
		String[] arrayStringsData = {"1984-08-18", "1983-04-23", "1954-11-26", "1952-05-29", "1975-08-25", "2021-10-22", "2021-12-01"};
		Date[] arrayDeDates = arrayStringToArrayDate(arrayStringsData);
		imprimirArrayDate(arrayDeDates);
		
//		Date dataEmDate = strSqlDateToDate("2021-12-01");
//		System.out.println("Convertendo data em String para data em Date: " + dataEmDate);
//		System.out.println("Classe da data em Date: " + dataEmDate.getClass());
		
//		gerarDatasDate();
//		gerarDatasDateLocalDate();
//		Date[] datasDeFatura = null;
//		List<String> listaDatas = DateToStringVetor(datasDeFatura);
//		imprimirListaDeDatas(listaDatas);
	}
	
	public static Date[] arrayStringToArrayDate(String[] arrayStringsData) {
		List<Date> listaDeDates = new ArrayList<Date>();
		for (String dataString : arrayStringsData) {
			Date dataDate = strSqlDateToDate(dataString);
			listaDeDates.add(dataDate);
		}
		return listToArrayJava(listaDeDates);
	}
	
	public static Date[] listToArrayJava (List<Date> listaDates) {
		Date[] arrayDates = new Date[listaDates.size()];		
		for(int i = 0; i < listaDates.size(); i++) {
			arrayDates[i] = listaDates.get(i);
		}
		return arrayDates;
	}	
	
	public static Date strSqlDateToDate(String str) {
		Date data = null;
		
		//0123456789
		//2020-02-18
		//1234567890
		String controle = str;
		
		String strdia = controle.substring(8, 10);
		int dia = stringToInteger(strdia);
		String strmes = controle.substring(5, 7);
		int mes = stringToInteger(strmes);
		String strano = controle.substring(0, 4);
		int ano = stringToInteger(strano);
		
		data = setSqlDate(dia, mes, ano);
		
		return data;
	}
	
	public static int stringToInteger(String str) {
		int valor;		
		try {
			valor = Integer.parseInt(str.trim());
		} catch (Exception e) {
			valor = 0;
		}

		return valor;
	}
	
	public static java.sql.Date setSqlDate(int dia, int mes, int ano) {
		Calendar data;
		TimeZone timezone = TimeZone.getTimeZone(new String("America/Sao_Paulo"));
		data = Calendar.getInstance(timezone);
		mes = mes - 1;
		data.clear();
		data.set(ano, mes, dia);
		return (new java.sql.Date(data.getTimeInMillis()));
	}

	public static void gerarDatasDateLocalDate() {
		LocalDate today = LocalDate.now();
		System.out.println("Data pelo LocalDate: " + today);
	}

	public static void gerarDatasDate() {
		Date date = new Date();
		System.out.println("Gerar datas pelo Date = " + date);
	}

	public static String DateToString(Date dataFatura) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(dataFatura);
		return strDate;
	}

	public static List<String> DateToStringVetor(Date[] datasDeFatura) {
		List<String> listaDatasString = new ArrayList<String>();
		int i = 0;
		for (Date date : datasDeFatura) {
			String dataString = DateToString(date);
			listaDatasString.add(dataString);
			System.out.println("Data[" + i + "] = " + date);
			i++;
		}
		return listaDatasString;
	}

	public static void imprimirListaDeDatas(List<String> listaDeDatas) {
		for (String UmaData : listaDeDatas) {
			System.out.println("Data: " + UmaData);
		}
	}
	
	public static void imprimirArrayString(String[] arrayString) {
		for (String s : arrayString) {
			System.out.println("Uma String do arrayString = " + s);
		}
	}
	
	public static void imprimirArrayDate(Date[] arrayDate) {
		for (Date d : arrayDate) {
			System.out.println("Uma data do arrayDate (tipo Date) = " + d);
		}
	}

}
